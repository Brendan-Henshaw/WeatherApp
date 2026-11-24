package com.example.weatherapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.Image
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.models.DayWeather

@Composable
fun ForecastScreen(
    forecast: List<DayWeather>
) {


    LazyColumn() {
        items(forecast) { day ->
            Row(modifier = Modifier.padding(25.dp)) {
                AsyncImage(
                    model = day.weatherImage,
                    contentDescription = day.condition
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column() {
                    Text(day.date,
                        style = MaterialTheme.typography.headlineSmall)

                    Text(day.condition,
                        style = MaterialTheme.typography.bodyMedium)

                    Text("High: ${day.highTemp}",
                        style = MaterialTheme.typography.bodyMedium)

                    Text("High: ${day.lowTemp}",
                        style = MaterialTheme.typography.bodyMedium)

                    Text("Max Wind: ${day.maxWind}",
                        style = MaterialTheme.typography.bodyMedium)

                    Text("Chance of Rain: ${day.precipChance}" + "Rainfall: ${day.precipitation}",
                        style = MaterialTheme.typography.bodyMedium)

                    Text("Humidity: ${day.humidity}",
                        style = MaterialTheme.typography.bodyMedium)
                }
            }

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
        }
    }
}