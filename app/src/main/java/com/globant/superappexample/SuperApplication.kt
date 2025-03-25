package com.globant.superappexample

import android.app.Application
import android.util.Log
import com.globant.utilities.logging.AppLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SuperApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppLogger.d(message = "Launch on Application")
    }

    companion object {
        const val TAG = "SuperApplication"
    }
}