package com.example.dailyplanner

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class DailyPlannerApp : Application() {

    companion object {
        const val PREF_NAME = "theme_pref"
        const val KEY_IS_DARK_MODE = "is_dark_mode"
    }

    override fun onCreate() {
        super.onCreate()
        applyThemePreference()
    }

    private fun applyThemePreference() {
        val sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean(KEY_IS_DARK_MODE, false)
        val mode = if (isDarkMode) {
            AppCompatDelegate.MODE_NIGHT_YES
        } else {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}