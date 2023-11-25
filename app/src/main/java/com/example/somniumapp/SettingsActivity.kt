package com.example.somniumapp

import ThemeHelper.setThemeOfApp
import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {
    private lateinit var sharedPrefs : SharedPreferences

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

        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        //sharedPrefs.registerOnSharedPreferenceChangeListener(preferenceChangeListener)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}