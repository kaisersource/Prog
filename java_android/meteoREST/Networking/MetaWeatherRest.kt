package app.com.kaisersource.meteorest.Networking

import app.com.kaisersource.meteorest.Models.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by kaisersource on 16/06/17.
 */

/*chiamate */
interface MetaWeatherRest {
    @GET("weatherData")
    fun getLocationDetails(@Header("X-Mashape-Key") key: String, @Header("Accept") type: String,
                           @Query("lat") lat: Double, @Query("lng") lng: Double): Observable<WeatherData>
}

//trasmissione della chiave e delle coordinate geografiche