package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weatherapp.models.CurrentWeather

@Composable
fun TodayScreen(
    weather: CurrentWeather
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        AsyncImage(
            model = weather.weatherImage,
            contentDescription = weather.condition
        )

        Text(weather.condition)

        Text("Temperature: ${weather.temperature}°C")

        Text("Feels Like: ${weather.feelsLike}°C")

        Text("Wind: ${weather.windDir} " + "${weather.windSpeed} km/h")

        Text("Chance of Rain: ${weather.precipChance}")

        Text("Rainfall: ${weather.precipitation}")

        Text("Humidity: ${weather.humidity}")

        Spacer(modifier = Modifier
            .height(10.dp))
    }
}