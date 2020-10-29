package com.alexgui.openweather

class ApiEndPoint{
    //http://api.openweathermap.org/data/2.5/forecast?zip=94040,us&appid=beca725a3e128eefc58234d44cd743f7
    companion object {
        val BASE_URL = "http://api.openweathermap.org/data/2.5/";
        val API_KEY = "beca725a3e128eefc58234d44cd743f7";
        val CITY_ID = "1880252"// singapore
        val UNITS = "metric"// metric=celcius, imperial=fahrenheit
    }
}