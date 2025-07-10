package com.example.myapp.ui.screens.hanuman

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import com.example.myapp.ui.navigation.Routes

@Composable
fun HanumanScreen(navController: NavController) {
    val aartis = listOf(
        "आरती कीजै हनुमान लला की" to Routes.HANUMAN_AARTI_1,
        "हनुमान चालीसा" to Routes.HANUMAN_AARTI_2,
        "हनुमान अष्टक" to Routes.HANUMAN_AARTI_3,
        "बजरंग बाण" to Routes.HANUMAN_AARTI_4,
        "जय जय हनुमान गोसाई" to Routes.HANUMAN_AARTI_5,
        "मंगल मूर्ति मारुति नंदन" to Routes.HANUMAN_AARTI_6
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
