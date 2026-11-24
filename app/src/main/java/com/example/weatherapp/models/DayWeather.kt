package com.example.weatherapp.models;

data class DayWeather(
    val date: String,
    val weatherImage: String,
    val condition: String,
    val highTemp: Double,
    val lowTemp: Double,
    val maxWind: Double,
    val precipChance: Int,
    val precipitation: Double,
    val humidity: Int
)
