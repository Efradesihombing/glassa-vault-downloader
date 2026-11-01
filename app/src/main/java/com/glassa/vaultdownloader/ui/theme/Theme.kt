package com.glassa.vaultdownloader.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = GlassaPrimary,
    secondary = GlassaSecondary,
    tertiary = GlassaAccent,
    background = GlassaBackgroundDark,
    surface = GlassaSurfaceDark,
    onPrimary = Color(0xFF07111D),
    onSecondary = Color(0xFF07111D),
    onBackground = Color(0xFFEAF6FF),
    onSurface = Color(0xFFEAF6FF)
)

private val LightColorScheme = lightColorScheme(
    primary = GlassaSecondary,
    secondary = GlassaPrimary,
    tertiary = GlassaAccent,
    background = GlassaBackgroundLight,
    surface = GlassaSurfaceLight,
    onPrimary = Color(0xFF081120),
    onSecondary = Color(0xFF081120),
    onBackground = Color(0xFF0F172A),
    onSurface = Color(0xFF0F172A)
)

@Composable
fun GlassaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
