package com.example.myapp.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapp.ui.navigation.Routes

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Routes.HOME } == true,
            onClick = {
                if (currentDestination?.route != Routes.HOME) {
                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.HOME) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Routes.DAYS_SCREEN } == true,
            onClick = {
                if (currentDestination?.route != Routes.DAYS_SCREEN) {
                    navController.navigate(Routes.DAYS_SCREEN) {
                        popUpTo(Routes.HOME)
                        launchSingleTop = true
                    }
                }
            },
            icon = { Icon(Icons.Default.Star, contentDescription = "Days") },
            label = { Text("Days") }
        )
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Routes.MANTRA_SCREEN } == true,
            onClick = {
                if (currentDestination?.route != Routes.MANTRA_SCREEN) {
                    navController.navigate(Routes.MANTRA_SCREEN) {
                        popUpTo(Routes.HOME)
                        launchSingleTop = true
                    }
                }
            },
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Mantra") },
            label = { Text("Mantra") }
        )
        NavigationBarItem(
            selected = currentDestination?.hierarchy?.any { it.route == Routes.ABOUT_SCREEN } == true,
            onClick = {
                if (currentDestination?.route != Routes.ABOUT_SCREEN) {
                    navController.navigate(Routes.ABOUT_SCREEN) {
                        popUpTo(Routes.HOME)
                        launchSingleTop = true
                    }
                }
            },
            icon = { Icon(Icons.Default.Info, contentDescription = "About") },
            label = { Text("About") }
        )
    }
}
