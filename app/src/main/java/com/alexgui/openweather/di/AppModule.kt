package com.alexgui.openweather.di

import android.content.Context
import com.alexgui.openweather.ApiEndPoint
import com.alexgui.openweather.model.local.AppDatabase
import com.alexgui.openweather.model.local.WeatherDao
import com.alexgui.openweather.model.remote.WeatherRemoteDataSource
import com.alexgui.openweather.model.remote.WeatherService
import com.alexgui.openweather.model.repository.WeatherRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
            .baseUrl(ApiEndPoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherService = retrofit.create(WeatherService::class.java)

    @Singleton
    @Provides
    fun provideWeatherRemoteDataSource(weatherService: WeatherService) = WeatherRemoteDataSource(weatherService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase) = db.weatherDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: WeatherRemoteDataSource,
                          localDataSource: WeatherDao) =
            WeatherRepository(remoteDataSource, localDataSource)
}