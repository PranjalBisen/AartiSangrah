package com.example.myapp.ui.screens.shiva

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.shape.RoundedCornerShape
import com.example.myapp.ui.navigation.Routes

@Composable
fun ShivaScreen(navController: NavController) {
    val aartis = listOf(
        "लवथवती विक्राळा" to Routes.SHIVA_AARTI_1,
        "कर्पूरगौर गौरीशंकरा" to Routes.SHIVA_AARTI_2,
        "ॐ जय शिव शंकरा" to Routes.SHIVA_AARTI_3,
        "आवड तुला बेलाची" to Routes.SHIVA_AARTI_4,
        "शिव तांडव स्तोत्र" to Routes.SHIVA_AARTI_5,
        "रुद्राष्टकम्" to Routes.SHIVA_AARTI_6,
        "कालभैरवाष्टकम्" to Routes.SHIVA_AARTI_7
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.popBackStack() }
            )
        }

        aartis.forEach { (title, route) ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .clickable { navController.navigate(route) }
                    .shadow(6.dp, RoundedCornerShape(16.dp)),
                color = MaterialTheme.colorScheme.surfaceVariant
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ShivaScreenPreview() {
    ShivaScreen(navController = rememberNavController())
}
