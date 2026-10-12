package com.example.weatherapp.models

data class HourWeather(
    val time: String,
    val weatherImage: Int,
    val temperature: String,
    val rain: String
)