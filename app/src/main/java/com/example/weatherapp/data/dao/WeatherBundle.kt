package com.example.weatherapp.data.dao

data class WeatherBundle(
    val locationName: String,
    val currentWeather: CurrentWeather,
    val forecast: List<ForecastWeather>
)