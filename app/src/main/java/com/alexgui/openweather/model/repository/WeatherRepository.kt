package com.alexgui.openweather.model.repository

import com.alexgui.openweather.model.local.WeatherDao
import com.alexgui.openweather.model.remote.WeatherRemoteDataSource
import com.alexgui.openweather.utils.performGetOperation
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val remoteDataSource: WeatherRemoteDataSource,
    private val localDataSource: WeatherDao

){
     fun getWeatherList() = performGetOperation(
        databaseQuery = { localDataSource.getWeatherList() },
        networkCall = { remoteDataSource.getWeatherList() },
        saveCallResult = { localDataSource.insertAll(it.list) }
    )
}