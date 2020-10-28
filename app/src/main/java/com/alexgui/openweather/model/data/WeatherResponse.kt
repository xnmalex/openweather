package com.alexgui.openweather.model.data

//weather response from open weather API
data class WeatherResponse(
    val cod: String,
    val message: Int,
    val cnt: Int,

    val list: List<Weather>,

    val city: City
)