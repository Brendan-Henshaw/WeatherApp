package com.example.weatherapp.data.dao

import android.service.notification.Condition

data class WeatherResponse(
    val location: LocationInfo,
    val current: Current,
    val forecast: Forecast
)

data class LocationInfo(
    val city: String,
    val region: String,
    val country: String
)

data class Current(
    val temp: Double,
    val feelsLike: Double,
    val humidity: Int,
    val windSpeed: Double,
    val windDir: String,
    val precipitation: Double,
    val condition: Condition
)

data class Forecast(
    val forecastDay: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day
)

data class Day(
    val minTemp: Double,
    val maxTemp: Double,
    val maxWind: Double,
    val totalPrecip: Double,
    val precipChance: Int,
    val avgHumidity: Double,
    val condition: Condition
)

data class Condition(
    val desc: String,
    val image: String
)