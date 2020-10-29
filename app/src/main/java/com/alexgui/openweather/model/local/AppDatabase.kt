package com.alexgui.openweather.model.local

import android.content.Context
import androidx.room.*
import com.alexgui.openweather.model.data.Weather
import com.alexgui.openweather.utils.Converters

@Database(entities = [Weather::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "weather")
                .fallbackToDestructiveMigration()
                .build()
    }

}