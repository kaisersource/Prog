package app.com.kaisersource.meteorest.Home

import android.content.Context
import app.com.kaisersource.meteorest.Consts.Constants
import app.com.kaisersource.meteorest.Models.WeatherData
import app.com.kaisersource.meteorest.Networking.NetworkService
import app.com.kaisersource.meteorest.Consts.Secrets
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.io.File

/**
 * Created by kaisersource on 21/06/17.
 */
class HomePresenter : HomeContract.Presenter {

    var mView: HomeContract.View? = null

    override fun subscribe(view: HomeContract.View) {
        mView = view

        //Load data from internal storage
        val storedWeather = getFile(mView?.getContext())
        if (storedWeather != null) {
            mView?.onStoredDataFetched(storedWeather)
        }
    }

    override fun unSubscribe() {
        mView = null
    }




    override fun refresh(lat: Double, long: Double) {
        NetworkService.getMetaWeatherApi()
                .getLocationDetails(Secrets.API_KEY, Constants.TYPE_TEXT_PLAIN, lat, long)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    weatherData ->
                    mView?.onDataFetched(weatherData)
                    storeFileToExternalStorage(weatherData, mView?.getContext())
                }, {
                    error ->
                    mView?.onError()
                })
    }

    /*
    * Salvataggio dei dati in un file avente una struttura json
    * Subscribe della chiamata REST
    */
    private fun storeFileToExternalStorage(weatherData: WeatherData, context: Context?) {
        val gson = Gson()
        val weatherJson = gson.toJson(weatherData)

        val weatherFile = File(mView?.getContext()?.filesDir, Constants.WEATHER_FILE_NAME)
        if (weatherFile.exists()) weatherFile.delete()
        weatherFile.createNewFile()

        val outputStream = mView?.getContext()?.openFileOutput(Constants.WEATHER_FILE_NAME, Context.MODE_PRIVATE)
        outputStream?.write(weatherJson.toByteArray())
        outputStream?.close()
    }

    /*
    * Lettura dati del tempo dal file JSon
    * Costruzione di un observable che restituisce il meteo attraverso il servizio rest
    */
    private fun getFile(context: Context?): WeatherData? {
        try {
            val weatherFile = File(context?.filesDir, Constants.WEATHER_FILE_NAME)
            val weatherJson = weatherFile.readText()
            val gson = Gson()
            val weatherData = gson.fromJson(weatherJson, WeatherData::class.java)
            return weatherData
        } catch (e: Exception) {
            return null
        }
    }
}