package com.example.myapp.ui.screens.mantra

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.myapp.ui.navigation.Routes

@Composable
fun MantraScreen(navController: NavController) {
    val mantras = listOf(
        "ॐ नमः शिवाय" to Routes.OM_NAMAH_SHIVAY,
        "ॐ गं गणपतये नमः" to Routes.OM_GAN_GANPATAYE_NAMAH,
        "ॐ नमो भगवते वासुदेवाय" to Routes.OM_NAMO_BHAGWATE_VASUDEVAY,
        "ॐ त्र्यम्बकं यजामहे" to Routes.OM_TRIYAMBAKAM,
        "ॐ हनुमते नमः (बीज मंत्र)" to Routes.HANUMAN_BEEJ_MANTRA,
        "ॐ श्रीं ह्रीं क्लीं महालक्ष्म्यै नमः" to Routes.MAHALAKSHMI_BEEJ_MANTRA,
        "ॐ ऐं महासरस्वत्यै नमः" to Routes.SARASWATI_BEEJ_MANTRA,
        "ॐ कृष्णाय वासुदेवाय हरये परमात्मने नमः" to Routes.KRISHNAYA_VASUDEVAY,
        "ॐ दिगंबरा दिगंबरा श्रीपाद वल्लभ दिगंबरा" to Routes.DIGAMBARA_DIGAMBARA,
        "ॐ सूर्याय नमः (बीज मंत्र)" to Routes.SURYA_BEEJ_MANTRA,
        "ॐ चन्द्राय नमः (बीज मंत्र)" to Routes.CHANDRA_BEEJ_MANTRA,
        "ॐ भौमाय नमः (मंगल बीज मंत्र)" to Routes.MANGAL_BEEJ_MANTRA,
        "ॐ बुधाय नमः (बुध बीज मंत्र)" to Routes.BUDH_BEEJ_MANTRA,
        "ॐ गुरवे नमः (गुरु बीज मंत्र)" to Routes.GURU_BEEJ_MANTRA,
        "ॐ शुक्राय नमः (शुक्र बीज मंत्र)" to Routes.SHUKRA_BEEJ_MANTRA,
        "ॐ शनैश्चराय नमः (शनि बीज मंत्र)" to Routes.SHANI_BEEJ_MANTRA,
        "ॐ रां राहवे नमः (राहु बीज मंत्र)" to Routes.RAHU_BEEJ_MANTRA,
        "ॐ कें केतवे नमः (केतु बीज मंत्र)" to Routes.KETU_BEEJ_MANTRA
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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

        Spacer(modifier = Modifier.height(8.dp))

        mantras.forEach { (title, route) ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .shadow(6.dp, RoundedCornerShape(16.dp))
                    .clickable(enabled = route.isNotEmpty()) {
                        if (route.isNotEmpty()) navController.navigate(route)
                    },
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

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MantraScreenPreview() {
    MantraScreen(navController = rememberNavController())
}
