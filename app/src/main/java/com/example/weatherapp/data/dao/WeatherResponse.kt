package com.example.weatherapp.data.dao

data class WeatherResponse(
    val location: LocationData,
    val current: Current,
    val forecast: Forecast
)

data class LocationData(
    val name: String,
    val region: String,
    val country: String
)

data class Current(
    val temp_c: Double,
    val feelslike_c: Double,
    val humidity: Int,
    val wind_kph: Double,
    val wind_dir: String,
    val precip_mm: Double,
    val condition: ConditionData
)

data class Forecast(
    val forecastDay: List<ForecastDayData>
)

data class ConditionData(
    val text: String,
    val icon: String
)

data class ForecastDayData(
    val date: String,
    val day: DayData
)

data class DayData(
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val maxwind_kph: Double,
    val totalprecip_mm: Double,
    val daily_chance_of_rain: Int,
    val avghumidity: Double,
    val condition: ConditionData
)