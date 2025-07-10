package com.example.myapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapp.ui.navigation.Routes

@Composable
fun SpiritualCornerScreen(navController: NavController) {
    val items = listOf(
        "१०८ ॐ नमः शिवाय" to Routes.MANTRA_SCREEN,
        "१०८ ॐ त्र्यंबकं यजामहे" to Routes.TRYAMBAKAM_SCREEN,
        "गायत्री मंत्र" to Routes.GAYATRI_SCREEN,
        "हनुमान बीज मंत्र" to Routes.HANUMAN_MANTRA_SCREEN,
        "कृष्ण महामंत्र" to Routes.KRISHNA_MANTRA_SCREEN
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        items.forEach { (title, route) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { navController.navigate(route) },
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.1f))
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
