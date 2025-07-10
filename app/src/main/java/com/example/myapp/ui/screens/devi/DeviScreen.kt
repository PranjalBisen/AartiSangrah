package com.example.myapp.ui.screens.devi

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp.ui.navigation.Routes
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.logEvent
import com.google.firebase.ktx.Firebase

@Composable
fun DeviScreen(navController: NavController) {
    val analytics = Firebase.analytics

    val aartis = listOf(
        "दुर्गे दुर्घट भारी" to Routes.DURGA_AARTI_1,
        "जय अम्बे गौरी" to Routes.DURGA_AARTI_2,
        "अम्बे तू है जगदम्बे काली" to Routes.DURGA_AARTI_3,
        "दुर्गा चालीसा" to Routes.DURGA_AARTI_4,
        "कामाक्षी स्तोत्रम्" to Routes.DURGA_AARTI_5,
        "महालक्ष्मी अष्टकम्" to Routes.DURGA_AARTI_6,
        "तुलसी मंगलाष्टक" to Routes.DURGA_AARTI_7,
        "या कुन्देन्दु तुषार हार धवला" to Routes.DURGA_AARTI_8,
        "ऐगिरी नन्दिनी" to Routes.DURGA_AARTI_9
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
                    .clickable {
                        val analytics = Firebase.analytics
                        analytics.logEvent("aarti_opened") {
                            param("god", "Ganpati")
                            param("aarti_title", title)
                        }
                        navController.navigate(route)
                    }
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
fun DeviScreenPreview() {
    DeviScreen(navController = rememberNavController())
}
