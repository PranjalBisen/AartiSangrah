package com.example.templefinder

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.google.android.gms.maps.model.*
import com.google.maps.android.compose.*

@SuppressLint("MissingPermission")
@Composable
fun TempleMapScreen() {
    val context = LocalContext.current
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

    var userLocation by remember { mutableStateOf<LatLng?>(null) }
    var permissionGranted by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        permissionGranted = granted
        if (granted) {
            fetchLocation(context, fusedLocationClient) { userLocation = it }
        }
    }

    LaunchedEffect(Unit) {
        val granted = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        permissionGranted = granted
        if (!granted) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        } else {
            fetchLocation(context, fusedLocationClient) { userLocation = it }
        }
    }

    Box(modifier = Modifier.fillMaxSize().padding(bottom = 56.dp)) {
        if (userLocation != null) {
            val cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(userLocation!!, 15f)
            }

            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                properties = MapProperties(isMyLocationEnabled = true),
                uiSettings = MapUiSettings(zoomControlsEnabled = true)
            ) {
                Marker(
                    state = MarkerState(position = userLocation!!),
                    title = "You are here",
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)
                )
            }
        } else {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

private fun fetchLocation(
    context: android.content.Context,
    fusedLocationClient: FusedLocationProviderClient,
    onLocationFound: (LatLng?) -> Unit
) {
    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        onLocationFound(null)
        return
    }

    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        if (location != null) {
            onLocationFound(LatLng(location.latitude, location.longitude))
        } else {
            fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                null
            ).addOnSuccessListener { newLocation ->
                onLocationFound(
                    newLocation?.let { LatLng(it.latitude, it.longitude) }
                )
            }.addOnFailureListener {
                onLocationFound(null)
            }
        }
    }.addOnFailureListener {
        onLocationFound(null)
    }
}