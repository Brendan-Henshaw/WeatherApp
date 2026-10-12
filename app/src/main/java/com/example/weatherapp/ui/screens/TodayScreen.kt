package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.weatherapp.R
import com.example.weatherapp.models.DayWeather

@Composable
fun TodayScreen() {
    val today = DayWeather(
        date="Sunday, October 11th",
        weatherImage = R.drawable.cloudy,
        temperature="High: 13°, Low: 3°",
        desc="Wind: 14 km/h, Humidity: 52%"
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(today.weatherImage),
            contentDescription = today.date,
            modifier = Modifier.size(250.dp)
        )

        Text(text = today.date,
            style = MaterialTheme.typography.displaySmall)

        Spacer(modifier = Modifier
            .height(10.dp))

        Text(today.temperature)

        Text(today.desc)
    }
}