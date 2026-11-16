package com.example.weatherapp.data

import com.example.weatherapp.data.*
import com.example.weatherapp.data.dao.*


class WeatherRepository(
    private val weatherApi: WeatherApi,
    private val locationService: Location
) {
    private val apiKey = BuildConfig.API_KEY

    suspend fun getWeather(): WeatherBundle {
        val location =
            locationService.getCurrentLocation()
                ?: throw Exception("Location Unavailable")

        val coordinates =
            "${location.latitude},${location.longitude}"

        val response =
            WeatherApi.getForecast(
                apiKey,
                coordinates,
                3
            )

        val currentWeather = CurrentWeather(
            image = "https:${response.current.condition.icon}",
            condition = response.current.condition.text,
            temp = response.current.temp_c,
            feelsLike = response.current.feelslike_c,
            windSpeed = response.current.wind_kph,
            windDir = response.current.wind_dir,
            precipChance = response.forecast.forecastday[0].day.daily_chance_of_rain,
            precipitation = response.current.precip_mm,
            humidity = response.current.humidity
        )

        val forecast =
            response.forecast.forecastday.map {
                ForecastWeather(
                    date = it.date,
                    image = "https:${it.day.condition.icon}",
                    condition = it.day.condition.text,
                    minTemp = it.day.mintemp_c,
                    maxTemp = it.day.maxtemp_c,
                    maxWind = it.day.maxwind_kph,
                    precipChance = it.day.daily_chance_of_rain,
                    precipitation = it.day.totalprecip_mm,
                    humidity = it.day.avghumidity.toInt()
                )
            }

        return WeatherBundle(
            locationName =
                "${response.location.city}, ${response.location.region}",
            currentWeather = currentWeather,
            forecast = forecast
        )
    }
}