package com.alexgui.openweather.model.remote

import com.alexgui.openweather.model.data.WeatherResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface WeatherService {

    @GET("")
    suspend fun getWeatherByZipCode() : Response<WeatherResponse>

    @GET("")
    suspend fun getWeatherByLatLng() : Response<WeatherResponse>
}