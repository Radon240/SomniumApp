package com.example.somniumapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {
    private lateinit var sharedPrefs: SharedPreferences

    private val sharedPrefsListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
        if (key == "theme_preference") {
            recreate()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(ThemeHelper.setThemeOfApp(sharedPrefs))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)

        val toolbar: Toolbar = findViewById(R.id.settings_toolbar)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        sharedPrefs.registerOnSharedPreferenceChangeListener(sharedPrefsListener)
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedPrefs.unregisterOnSharedPreferenceChangeListener(sharedPrefsListener)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}