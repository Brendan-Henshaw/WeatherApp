package com.example.weatherapp

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.dao.*
import com.example.weatherapp.models.CurrentWeather
import com.example.weatherapp.models.DayWeather
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: WeatherRepository
) : ViewModel() {
    var currentWeather by mutableStateOf<CurrentWeather?>(null)
        private set
    var forecast by mutableStateOf<List<DayWeather>>(emptyList())
        private set

    init {
        loadWeather()
    }

    private fun loadWeather() {
        viewModelScope.launch {
            currentWeather =
                repository.getCurrentWeather()

            forecast =
                repository.getForecast()
        }
    }
}