package com.example.myapp.ui.screens

import androidx.activity.ComponentActivity
import androidx.compose.runtime.*
import com.example.myapp.MainScreen
import com.example.myapp.screens.LoginScreen

@Composable
fun AuthNavigator(activity: ComponentActivity) {
    var verificationId by remember { mutableStateOf<String?>(null) }
    var isVerified by remember { mutableStateOf(false) }

    when {
        isVerified -> MainScreen()
        verificationId != null -> OTPScreen(
            verificationId = verificationId!!,
            onVerified = { isVerified = true }
        )
        else -> LoginScreen(
            activity = activity,
            onCodeSent = { id -> verificationId = id }
        )
    }
}
