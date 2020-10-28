package com.alexgui.openweather.model.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "weather")
data class Weather(
    @PrimaryKey(autoGenerate = true)
    val dt:Long,

    @Embedded
    val main: WeatherMain,

    @SerializedName("weather_items")
    @Expose
    val weather: List<WeatherItem>,

    @Embedded
    val clouds: Cloud,

    @Embedded
    val wind: Wind,

    val visibility: Int,
    val pop: Int,

    @Embedded
    val sys: Sys,
    val dt_txt:String
)


data class WeatherMain(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val humidity: Int,
    val temp_kf: Double

)

data class WeatherItem(
    val id: Long,
    val main: String,
    val description: String,
    val icon: String
)

data class Cloud(
    val all: Int
)

data class Wind(
    val speed: Double,
    val degree: Int
)

data class Sys(
    val pod: String
)

data class City(
    val id: Long,
    val name: String,

    @Embedded
    val coord: Coordinate,

    val country: String,
    val population: Long,
    val timezone: Int,
    val sunrise: Long,
    val sunset:Long
)

data class Coordinate(
    val lat: Double,
    val lon: Double
)