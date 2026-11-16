package com.example.weatherapp.data.dao

data class ForecastWeather(
    val date: String,
    val image: String,
    val condition: String,
    val minTemp: Double,
    val maxTemp: Double,
    val maxWind: Double,
    val precipChance: Int,
    val precipitation: Double,
    val humidity: Int
)