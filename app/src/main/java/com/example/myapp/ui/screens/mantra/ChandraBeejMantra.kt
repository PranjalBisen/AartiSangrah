package com.example.myapp.ui.screens.mantra

import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapp.R

@Composable
fun ChandraBeejMantra(navController: NavController) {
    val context = LocalContext.current
    val chantOptions = listOf(11, 21, 51, 108)

    var chantCount by remember { mutableStateOf(0) }
    var currentCount by remember { mutableStateOf(0) }
    var isPlaying by remember { mutableStateOf(false) }
    var showOptions by remember { mutableStateOf(false) }
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    DisposableEffect(isPlaying) {
        if (isPlaying) {
            mediaPlayer = MediaPlayer.create(context, R.raw.chandra_beej_mantra)
            mediaPlayer?.setOnCompletionListener {
                if (currentCount < chantCount) {
                    currentCount++
                    mediaPlayer?.start()
                } else {
                    mediaPlayer?.release()
                    mediaPlayer = null
                    isPlaying = false
                }
            }
            currentCount = 1
            mediaPlayer?.start()
        }

        onDispose {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.om),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAA000000))
        )

        Text(
            text = stringResource(id = R.string.ChandraBeejMantra),
            fontSize = 26.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 80.dp)
                .align(Alignment.TopCenter)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(16.dp)
                .size(32.dp)
                .clickable {
                    mediaPlayer?.stop()
                    mediaPlayer?.release()
                    isPlaying = false
                    navController.popBackStack()
                }
                .align(Alignment.TopStart),
            tint = Color.White
        )

        if (isPlaying) {
            Text(
                text = "Chanting ($currentCount / $chantCount)",
                fontSize = 16.sp,
                color = Color.Yellow,
                modifier = Modifier
                    .align(Alignment.Center)
                    .background(Color.Black.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }

        if (showOptions) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color(0xFFFAFAFA),
                tonalElevation = 8.dp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .wrapContentSize()
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Choose Chant Count", fontSize = 18.sp, color = Color.Black)
                    chantOptions.forEach { count ->
                        Button(
                            onClick = {
                                chantCount = count
                                currentCount = 0
                                isPlaying = true
                                showOptions = false
                            },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1B5E20))
                        ) {
                            Text("$count Times", color = Color.White)
                        }
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = {
                if (isPlaying) {
                    isPlaying = false
                    currentCount = 0
                } else {
                    showOptions = true
                }
            },
            shape = CircleShape,
            containerColor = Color(0xFF1B5E20),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 90.dp, end = 24.dp)
        ) {
            Icon(
                imageVector = if (isPlaying) Icons.Default.Close else Icons.Default.PlayArrow,
                contentDescription = "Play/Stop",
                tint = Color.White
            )
        }
    }
}
