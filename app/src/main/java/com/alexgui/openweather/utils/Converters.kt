package com.alexgui.openweather.utils

import androidx.room.TypeConverter
import com.alexgui.openweather.model.data.Weather
import com.alexgui.openweather.model.data.WeatherItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromWeatherItemList(weatherItem: List<WeatherItem?>?): String? {
        val type = object : TypeToken<List<WeatherItem>>() {}.type
        return Gson().toJson(weatherItem, type)
    }
    @TypeConverter
    fun toWeatherItemList(weatherItemString: String?): List<WeatherItem>? {
        val type = object : TypeToken<List<WeatherItem>>() {}.type
        return Gson().fromJson<List<WeatherItem>>(weatherItemString, type)
    }

    @TypeConverter
    fun fromWeatherList(weather: List<Weather?>?): String? {
        val type = object : TypeToken<List<Weather>>() {}.type
        return Gson().toJson(weather, type)
    }
    @TypeConverter
    fun toWeatherList(weatherString: String?): List<Weather>? {
        val type = object : TypeToken<List<Weather>>() {}.type
        return Gson().fromJson<List<Weather>>(weatherString, type)
    }

}