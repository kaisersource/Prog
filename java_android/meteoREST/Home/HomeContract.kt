package app.com.kaisersource.meteorest.Home

import android.content.Context
import app.com.kaisersource.meteorest.Models.WeatherData

/**
 * Created by kaisersource on 21/06/17.
 */

//Scrittura dell'interfaccio di contratto  per
//descrivere l'interazione tra la view (Homeactivity) e Presenter
interface HomeContract {

    interface View {
        fun onDataFetched(weatherData: WeatherData?)

        fun onStoredDataFetched(weatherData: WeatherData?)

        fun onError()

        fun getContext(): Context
    }

    //do publish subscribe
    interface Presenter {
        fun subscribe(view: View)

        fun unSubscribe()

        fun refresh(lat: Double, long: Double);
    }
}