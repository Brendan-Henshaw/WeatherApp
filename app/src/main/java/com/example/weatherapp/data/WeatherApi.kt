package com.example.weatherapp.data

import retrofit2.*
import retrofit2.http.*
import com.example.weatherapp.data.dao.*

interface WeatherApi {

    @GET("v1/forecast.json")
    suspend fun getForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int = 1
    ): Response<WeatherResponse>
}