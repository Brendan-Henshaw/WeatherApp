package com.example.weatherapp.data.dao

data class CurrentWeather(
    val image: String,
    val condition: String,
    val temp: Double,
    val feelsLike: Double,
    val windSpeed: Double,
    val windDir: String,
    val precipChance: Int,
    val precipitation: Double,
    val humidity: Int
)