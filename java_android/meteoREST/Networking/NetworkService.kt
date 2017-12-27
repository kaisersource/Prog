package app.com.kaisersource.meteorest.Networking

import app.com.kaisersource.meteorest.Consts.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


/**
 * Created by kaisersource on 16/06/17.
 */
object NetworkService {
    val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) //Consts
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    fun getMetaWeatherApi() = retrofit.create(MetaWeatherRest::class.java)//POJO
}