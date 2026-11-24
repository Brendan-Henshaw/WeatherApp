package com.example.weatherapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import com.example.weatherapp.ui.screens.*
import com.example.weatherapp.R
import com.example.weatherapp.data.dao.Forecast
import com.example.weatherapp.models.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(
    currentWeather: CurrentWeather?,
    forecast: List<DayWeather>
) {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) } // default set to 0

    val testWeather = CurrentWeather(
        location = "Lower Sackville, Nova Scotia",
        weatherImage = "",
        condition = "Partly Cloudy",
        temperature = 12.0,
        feelsLike = 10.0,
        windDir = "NW",
        windSpeed = 15.0,
        precipChance = 20,
        precipitation = 0.0,
        humidity = 65
    )

    val testForecast = listOf(
        DayWeather(
            date = "2026-11-24",
            weatherImage = "",
            condition = "Partly Cloudy",
            highTemp = 12.0,
            lowTemp = 4.0,
            maxWind = 20.0,
            precipChance = 30,
            precipitation = 1.2,
            humidity = 65
        ),
        DayWeather(
            date = "2026-11-25",
            weatherImage = "",
            condition = "Rain",
            highTemp = 10.0,
            lowTemp = 3.0,
            maxWind = 25.0,
            precipChance = 80,
            precipitation = 12.5,
            humidity = 82
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        currentWeather?.location
                            ?: "Loading..."
                    )
                }
            )
        },
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets)
            {
                NavigationBarItem(
                    icon = { Icon(painter = painterResource(R.drawable.calendar_today_24px), contentDescription = "Today") },
                    label = { Text("Today") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(route="today"){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                NavigationBarItem(
                    icon = { Icon(painter = painterResource(R.drawable.calendar_month_24px), contentDescription = "Forecast") },
                    label = { Text("Forecast") },
                    selected = selectedIndex == 1,
                    onClick = {
                        selectedIndex = 1
                        navController.navigate(route="forecast"){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }

    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "today",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "today") {
                currentWeather?.let {
                    TodayScreen(it)
                }
            }
            composable(route = "forecast") {
                ForecastScreen(forecast)
            }
        }
    }
}