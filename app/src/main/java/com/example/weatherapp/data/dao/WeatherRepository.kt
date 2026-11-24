package com.example.weatherapp.data.dao

import com.example.weatherapp.data.LocationService
import com.example.weatherapp.data.WeatherApi
import com.example.weatherapp.models.*
import com.example.weatherapp.BuildConfig

class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val locationService: LocationService

) {
    private val apiKey = BuildConfig.WEATHER_API_KEY

    private suspend fun fetchWeather(): WeatherResponse {
        val location =
            locationService.getCurrentLocation()
                ?: throw Exception(
                    "Location Unavailable"
                )
        val coordinates =
            "${location.latitude}" + "${location.longitude}"

        return weatherApi.getWeather(
            apiKey,
            coordinates,
            3
        )
    }
    suspend fun getCurrentWeather(): CurrentWeather {
        val response = fetchWeather()

        val location = "${response.location.name}, " + response.location.region

        return CurrentWeather(
            location = location,
            weatherImage = "https:${response.current.condition.icon}",
            condition = response.current.condition.text,
            temperature = response.current.temp_c,
            feelsLike = response.current.feelslike_c,
            windDir = response.current.wind_dir,
            windSpeed = response.current.wind_kph,
            precipChance = response.forecast.forecastDay[0].day.daily_chance_of_rain,
            precipitation = response.current.precip_mm,
            humidity = response.current.humidity
        )
    }
    suspend fun getForecast(): List<DayWeather> {
        val response = fetchWeather()

        return response.forecast
            .forecastDay
            .map { day ->
                DayWeather(
                    date = day.date,
                    weatherImage = "https:${day.day.condition.icon}",
                    condition = day.day.condition.text,
                    highTemp = day.day.maxtemp_c,
                    lowTemp = day.day.mintemp_c,
                    maxWind = day.day.maxwind_kph,
                    precipChance = day.day.daily_chance_of_rain,
                    precipitation = day.day.totalprecip_mm,
                    humidity = day.day.avghumidity.toInt()
                )
            }
    }
}