package com.alexgui.openweather.model.remote

import com.alexgui.openweather.ApiEndPoint
import com.alexgui.openweather.model.data.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("forecast")
    suspend fun getWeatherByZipCode(@Query("id") id:String?= ApiEndPoint.CITY_ID,
                                    @Query("appid") appid:String = ApiEndPoint.API_KEY,
                                    @Query("units") units:String = ApiEndPoint.UNITS) : Response<WeatherResponse>

    @GET("")
    suspend fun getWeatherByLatLng() : Response<WeatherResponse>
}