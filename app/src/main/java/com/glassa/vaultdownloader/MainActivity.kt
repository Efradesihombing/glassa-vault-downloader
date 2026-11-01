package com.glassa.vaultdownloader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.glassa.vaultdownloader.ui.components.GlassNavigationBar
import com.glassa.vaultdownloader.ui.components.NavItem
import com.glassa.vaultdownloader.ui.navigation.AppNavHost
import com.glassa.vaultdownloader.ui.navigation.AppScreen
import com.glassa.vaultdownloader.ui.theme.GlassaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GlassaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GlassaVaultScreen()
                }
            }
        }
    }
}

@Composable
fun GlassaVaultScreen() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableIntStateOf(0) }

    val navItems = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Status", Icons.Default.Image),
        NavItem("Unduhan", Icons.Default.Download),
        NavItem("Library", Icons.Default.LibraryBooks),
        NavItem("Setting", Icons.Default.Settings)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF07111D),
                        Color(0xFF101A2A),
                        Color(0xFF111827)
                    )
                )
            )
            .systemBarsPadding()
    ) {
        AppNavHost(navController = navController)

        Box(
            modifier = Modifier.align(Alignment.BottomCenter),
            contentAlignment = Alignment.Center
        ) {
            GlassNavigationBar(
                selectedIndex = selectedIndex,
                items = navItems,
                onSelected = { index ->
                    selectedIndex = index
                    when (index) {
                        0 -> navController.navigate(AppScreen.HOME.route)
                        1 -> navController.navigate(AppScreen.STATUS.route)
                        2 -> navController.navigate(AppScreen.DOWNLOADS.route)
                        3 -> navController.navigate(AppScreen.LIBRARY.route)
                        4 -> navController.navigate(AppScreen.SETTINGS.route)
                    }
                }
            )
        }
    }
}
