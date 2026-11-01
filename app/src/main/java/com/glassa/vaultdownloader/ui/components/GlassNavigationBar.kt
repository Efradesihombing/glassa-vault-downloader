package com.glassa.vaultdownloader.ui.navigation

enum class AppScreen(val route: String, val title: String) {
    HOME("home", "Home"),
    STATUS("status", "Status"),
    DOWNLOADS("downloads", "Downloads"),
    LIBRARY("library", "Library"),
    SETTINGS("settings", "Settings")
}

fun AppScreen.Companion.fromRoute(route: String?): AppScreen? = when (route) {
    HOME.route -> HOME
    STATUS.route -> STATUS
    DOWNLOADS.route -> DOWNLOADS
    LIBRARY.route -> LIBRARY
    SETTINGS.route -> SETTINGS
    else -> null
}
