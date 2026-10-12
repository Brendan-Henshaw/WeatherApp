package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.HourWeather

@Composable
fun HourlyScreen() {

    val hourlyDisplay = listOf(
        HourWeather(
            time="7:00 AM",
            weatherImage = R.drawable.rainy_3_day,
            temperature="9°",
            rain="60%"),
        HourWeather(
            time="8:00 AM",
            weatherImage = R.drawable.cloudy_2_day,
            temperature="9°",
            rain="10%"),
        HourWeather(
            time="9:00 AM",
            weatherImage = R.drawable.cloudy_2_day,
            temperature="9°",
            rain="10%"),
        HourWeather(
            time="10:00 AM",
            weatherImage = R.drawable.rainy_3_day,
            temperature="10°",
            rain="30%"),
        HourWeather(
            time="11:00 AM",
            weatherImage = R.drawable.cloudy_2_day,
            temperature="11°",
            rain="15%"),
        HourWeather(
            time="12:00 PM",
            weatherImage =R.drawable.cloudy_2_day,
            temperature="12°",
            rain="10%")
    )

    LazyRow() {
        items(hourlyDisplay) { hour ->

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(25.dp)) {

                Text(
                    text = hour.time,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                Image(
                    painter = painterResource(id = hour.weatherImage),
                    contentDescription = hour.time,
                    modifier = Modifier.size(80.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = hour.temperature,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = hour.rain,
                    style = MaterialTheme.typography.titleSmall
                )
            }
        }
    }
}