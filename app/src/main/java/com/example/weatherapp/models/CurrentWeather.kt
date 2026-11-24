package com.example.weatherapp.models

data class CurrentWeather(
    val location: String,
    val weatherImage: String,
    val condition: String,
    val temperature: Double,
    val feelsLike: Double,
    val windDir: String,
    val windSpeed: Double,
    val precipChance: Int,
    val precipitation: Double,
    val humidity: Int
)