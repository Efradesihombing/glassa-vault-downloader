package com.glassa.vaultdownloader.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.glassa.vaultdownloader.ui.downloads.DownloadsScreen
import com.glassa.vaultdownloader.ui.home.HomeScreen
import com.glassa.vaultdownloader.ui.library.LibraryScreen
import com.glassa.vaultdownloader.ui.settings.SettingsScreen
import com.glassa.vaultdownloader.ui.status.StatusScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = AppScreen.HOME.route,
            modifier = Modifier.fillMaxSize()
        ) {
            composable(AppScreen.HOME.route) {
                HomeScreen()
            }
            composable(AppScreen.STATUS.route) {
                StatusScreen()
            }
            composable(AppScreen.DOWNLOADS.route) {
                DownloadsScreen()
            }
            composable(AppScreen.LIBRARY.route) {
                LibraryScreen()
            }
            composable(AppScreen.SETTINGS.route) {
                SettingsScreen()
            }
        }
    }
}
