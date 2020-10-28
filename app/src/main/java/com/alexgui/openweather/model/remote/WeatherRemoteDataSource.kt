package com.alexgui.openweather.model.remote

import javax.inject.Inject

class WeatherRemoteDataSource @Inject constructor(
    private val weatherService: WeatherService
): BaseDataSource(){
    suspend fun getWeatherList() = getResult {weatherService.getWeatherByZipCode()}

    suspend fun getWeatherListByLatLng() = getResult {weatherService.getWeatherByLatLng()}
}