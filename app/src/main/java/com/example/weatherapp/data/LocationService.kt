package com.example.weatherapp.data

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import com.google.android.gms.location.*

class LocationService(
    context: Context
) {
    private val fusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    suspend fun getCurrentLocation(): Location? {
        return kotlinx.coroutines.suspendCancellableCoroutine { continuation ->
            fusedLocationProviderClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                null
            ).addOnSuccessListener {
                continuation.resume(it) {}
            }.addOnFailureListener {
                continuation.resume(null) {}
            }
        }
    }
}