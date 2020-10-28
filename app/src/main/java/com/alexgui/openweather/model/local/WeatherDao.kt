package com.alexgui.openweather.model.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alexgui.openweather.model.data.Weather

@Dao
interface WeatherDao{
    @Query("SELECT * FROM weather")
    fun getWeatherList(): LiveData<List<Weather>>

//    @Query("SELECT * FROM weather WHERE id = :id")
//    fun getCharacter(id: Int): LiveData<Weather>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weathers: List<Weather>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(weather: Weather)
}