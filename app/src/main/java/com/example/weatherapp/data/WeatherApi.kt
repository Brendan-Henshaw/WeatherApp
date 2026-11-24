package com.example.weatherapp.data

import com.example.weatherapp.data.dao.*
import retrofit2.http.*

interface WeatherApi {
    @GET("v1/forecast.json")
    suspend fun getWeather(
        @Query("key") apikey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 3
    ): WeatherResponse
}