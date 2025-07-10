package com.example.myapp.ui.screens

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.myapp.MainScreen
import com.example.myapp.screens.LoginScreen
import com.example.myapp.storage.UserPreferences
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun AuthNavigator() {
    val context = LocalContext.current
    val userPrefs = remember { UserPreferences(context) }
    val auth = remember { FirebaseAuth.getInstance() }
    var isLoggedIn by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        val shouldRemember = userPrefs.getRememberMe()
        val user = auth.currentUser
        isLoggedIn = shouldRemember && user != null
    }

    if (isLoggedIn) {
        MainScreen()
    } else {
        LoginScreen(onLoginSuccess = {
            scope.launch { userPrefs.setRememberMe(true) }
            isLoggedIn = true
        })
    }
}
