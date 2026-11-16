package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.WeatherRepository
import com.example.weatherapp.data.dao.WeatherBundle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weather =
        MutableStateFlow<WeatherBundle?>(null)

    val weather: StateFlow<WeatherBundle?> =
        _weather

    fun loadWeather() {
        viewModelScope.launch {
            _weather.value =
                repository.getWeather()
        }
    }
}