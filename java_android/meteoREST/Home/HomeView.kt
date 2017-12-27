package app.com.kaisersource.meteorest.Home

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import app.com.kaisersource.meteorest.Dialogs.ForecastDialogFragment
import app.com.kaisersource.meteorest.Models.WeatherData
import app.com.kaisersource.kotlinweather.R
import app.com.kaisersource.meteorest.Utils.WeatherToImage

class HomeView : AppCompatActivity(), HomeContract.View {

    private val RC_ENABLE_LOCATION = 1
    private val RC_LOCATION_PERMISSION = 2
    private val TAG_FORECAST_DIALOG = "forecast_dialog"
    var mPresenter: HomeContract.Presenter? = null
    var mLocationManager: LocationManager? = null
    var mSwipeRefreshLayout: SwipeRefreshLayout? = null
    var mLocation: Location? = null

    /*
    * Refresh the weather location on location changed
    * */
    //chiamata alla funzione del server per refreshare il layout
    var mLocationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            mSwipeRefreshLayout?.isRefreshing = true
            mPresenter?.refresh(location?.latitude ?: 0.0, location?.longitude ?: 0.0)

            //Check if the location is not null
            //Remove the location listener as we don't need to fetch the weather again and again
            if (location?.latitude != null && location.latitude != 0.0 && location.longitude != 0.0) {
                mLocation = location
                mLocationManager?.removeUpdates(this)
            }
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {
        }

        override fun onProviderDisabled(provider: String?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout) as SwipeRefreshLayout
        mLocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        mPresenter = HomePresenter()
        mPresenter?.subscribe(this)

        initViews()

        if (checkAndAskForLocationPermissions()) {
            checkGpsEnabledAndPrompt()
        }
    }

    private fun initViews() {
        mSwipeRefreshLayout?.setOnRefreshListener {
            if (mLocation != null) {
                mPresenter?.refresh(mLocation?.latitude ?: 0.0, mLocation?.longitude ?: 0.0)
            } else {
                mSwipeRefreshLayout?.isRefreshing = false
            }
        }
    }

    override fun getContext() = this

    override fun onStoredDataFetched(weatherData: WeatherData?) {
        updateUI(weatherData)
    }

    override fun onDataFetched(weatherData: WeatherData?) {
        //Stop the swipe refresh layout
        mSwipeRefreshLayout?.isRefreshing = false
        updateUI(weatherData)
    }

    /*
    * Aggiorna l'UI al variare del json
    * */
    private fun updateUI(weatherData: WeatherData?) {
        val temperatureTextView = findViewById(R.id.temperature_text_view) as TextView
        val windSpeedTextView = findViewById(R.id.wind_speed_text_view) as TextView
        val humidityTextView = findViewById(R.id.humidity_text_view) as TextView
        val weatherImageView = findViewById(R.id.weather_image_view) as ImageView
        val weatherConditionTextView = findViewById(R.id.weather_condition_text_view) as TextView
        val cityNameTextView = findViewById(R.id.city_name_text_view) as TextView

        val formattedTemperatureText = String.format(getString(R.string.celcuis_temperature), weatherData?.query?.results?.channel?.item?.condition?.temp ?: "")

        temperatureTextView.text = formattedTemperatureText
        windSpeedTextView.text = "${weatherData?.query?.results?.channel?.wind?.speed ?: ""} km/h"
        humidityTextView.text = "${weatherData?.query?.results?.channel?.atmosphere?.humidity ?: ""} %"


        //imposta le condizioni meteo
        val weatherCode = weatherData?.query?.results?.channel?.item?.condition?.code ?: "3200"
        weatherImageView.setImageResource(WeatherToImage.getImageForCode(weatherCode))
        weatherConditionTextView.text = weatherData?.query?.results?.channel?.item?.condition?.text ?: ""

        //parametri dello stato,città e regione
        val city = weatherData?.query?.results?.channel?.location?.city ?: ""
        val country = weatherData?.query?.results?.channel?.location?.country ?: ""
        val region = weatherData?.query?.results?.channel?.location?.region ?: ""
        cityNameTextView.text = "${city.trim()}, ${region.trim()}, ${country.trim()}"

        //Set up the forecast recycler view
        val forecastRecyclerView = findViewById(R.id.forecast_recycler_view) as RecyclerView
        val forecastRecyclerAdapter = ForecastRecyclerAdapter(this, weatherData?.query?.results?.channel?.item?.forecast?.asList())


            forecastRecyclerAdapter.addActionListener { forecast ->
                val forecastDialog = ForecastDialogFragment.getInstance(forecast)
                forecastDialog.show(supportFragmentManager, TAG_FORECAST_DIALOG)

            }


        forecastRecyclerView.adapter = forecastRecyclerAdapter
        forecastRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    override fun onError() {
        mSwipeRefreshLayout?.isRefreshing = false

        //Show snackbar to retry
        val coordinatorLayout = findViewById(R.id.coordinator_layout) as CoordinatorLayout

        val retrySnackBar = Snackbar.make(coordinatorLayout, "Impossibile leggere i dati relativi al tempo", Snackbar.LENGTH_INDEFINITE)
        retrySnackBar.setAction("Retry") {
            v ->
            mPresenter?.refresh(mLocation?.latitude ?: 0.0, mLocation?.longitude ?: 0.0)
            mSwipeRefreshLayout?.isRefreshing = true
            retrySnackBar.dismiss()
        }
        retrySnackBar.setActionTextColor(ContextCompat.getColor(this, R.color.md_white_1000))
        retrySnackBar.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter?.unSubscribe()
        mLocationManager?.removeUpdates(mLocationListener)
    }

    /*Verifica se il gps  è abilitato dall'utente,
    in caso positivo, 1- inizia a leggere i dati relativi alla posizione
    in caso negativo, 2- viene richiesto all'utente di attivare il gps e torna al passo 1
    */
    private fun checkGpsEnabledAndPrompt() {
        //Verifica abilitazione del gps
        val isLocationEnabled = mLocationManager!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (!isLocationEnabled) {
            //Mostra all'utente l'attivazione del gps
            AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle("GPS non abilitato!")
                    .setMessage("Quest'applicazione richiede l'uso del GPS. Desidera abilitarlo?")
                    .setPositiveButton(android.R.string.ok, {
                        dialog, which ->
                        //Start settings to enable location
                        val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                        startActivityForResult(intent, RC_ENABLE_LOCATION)

                        dialog.dismiss()
                    })
                    .setNegativeButton(android.R.string.cancel, {
                        dialog, which ->
                        dialog.dismiss()
                    })
                    .create()
                    .show()
        } else {
            requestLocationUpdates()
        }
    }

    /*
    * Metodo per ricevere gli aggiornamenti di posizione
    * */
    private fun requestLocationUpdates() {
        val provider = LocationManager.NETWORK_PROVIDER

        //Add the location listener and request updated
        mLocationManager?.requestLocationUpdates(provider, 0, 0.0f, mLocationListener)

        val location = mLocationManager?.getLastKnownLocation(provider)
        mLocationListener.onLocationChanged(location)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            RC_ENABLE_LOCATION -> {
                checkGpsEnabledAndPrompt()
            }
        }
    }

    /*
    * Verifica se i permessi di posizione sono stati garantiti dall'utente  * */
    private fun checkAndAskForLocationPermissions(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), RC_LOCATION_PERMISSION)
                return false
            }
        }
        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            RC_LOCATION_PERMISSION -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkGpsEnabledAndPrompt()
                } else {
                    checkAndAskForLocationPermissions()
                }
            }
        }
    }
}
