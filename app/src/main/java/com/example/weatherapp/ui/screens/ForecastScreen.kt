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
import com.example.weatherapp.R
import com.example.weatherapp.models.DayWeather

@Composable
fun ForecastScreen() {

    val forecast = listOf(
        DayWeather(
            date="Sunday Oct. 11th",
            weatherImage = R.drawable.cloudy,
            temperature="High: 13°, Low: 3°",
            desc="Wind: 14 km/h, Humidity: 52%"),
        DayWeather(
            date="Monday Oct. 12",
            weatherImage = R.drawable.rainy_2,
            temperature="High: 15°, Low: 4°",
            desc="Rain: 6.3 mm, Wind: 21 km/h, Humidity: 86%"),
        DayWeather(
            date="Tuesday Oct. 13th",
            weatherImage = R.drawable.cloudy,
            temperature="High: 10°, Low: 4°",
            desc="Wind: 13 km/h, Humidity: 62%"),
        DayWeather(
            date="Wed. Oct. 13th",
            weatherImage = R.drawable.rainy_3,
            temperature="High: 12°, Low: 7°",
            desc="Rain: 25.4 mm, Wind: 26 km/h, Humidity: 94%"),
        DayWeather(
            date="Thurs. Oct. 14th",
            weatherImage = R.drawable.cloudy_2_day,
            temperature="High: 12°, Low: 2°",
            desc="Wind: 23 km/hr, Humidity: 70%")

    )

    LazyColumn() {
        items(forecast) { day ->
            Row(modifier = Modifier.padding(25.dp)) {
                Image(
                    painter = painterResource(id = day.weatherImage),
                    contentDescription = day.date,
                    modifier = Modifier.size(80.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column() {
                    Text(day.date,
                        style = MaterialTheme.typography.headlineSmall)

                    Text(day.temperature,
                        style = MaterialTheme.typography.bodyLarge)

                    Text(day.desc,
                        style = MaterialTheme.typography.bodyMedium)
                }
            }

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
        }
    }
}