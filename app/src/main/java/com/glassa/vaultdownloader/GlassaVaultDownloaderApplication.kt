package com.glassa.vaultdownloader

import android.app.Application
import android.util.Log

class GlassaVaultDownloaderApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("GlassaVaultDownloader", "Application initialized")
    }
}
