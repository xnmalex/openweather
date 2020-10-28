package com.alexgui.openweather.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.alexgui.openweather.model.data.Weather
import com.alexgui.openweather.model.repository.WeatherRepository
import com.alexgui.openweather.utils.Resource

class WeatherViewModel @ViewModelInject constructor(
    weatherRepository: WeatherRepository
): ViewModel(){
    val weatherList : LiveData<Resource<List<Weather>>> = weatherRepository.getWeatherList();

    //("debug", ""+weatherList);

}