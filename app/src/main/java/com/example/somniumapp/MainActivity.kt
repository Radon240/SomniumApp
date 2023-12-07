package com.example.somniumapp

import Gameplay
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.somniumapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(ThemeHelper.setThemeOfApp(sharedPreferences))

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.app_name, R.string.app_name)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)

        toolbar = findViewById(R.id.toolbar)

        drawerLayout = binding.drawerLayout
        navView = binding.navView
    }

    override fun onRestart() {
        super.onRestart()
        recreate()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.nav_home -> replaceFragment(Home())

            R.id.nav_faqFragment -> replaceFragment(Faq())
            R.id.nav_gameplayFragment -> replaceFragment(Gameplay())
            R.id.nav_economyFragment -> replaceFragment(Economy())
            R.id.nav_donateFragment -> replaceFragment(Donate())

            R.id.nav_dynMap -> openLinkInBrowser("https://map.scmc.dev/")
            R.id.nav_discordLink -> openLinkInBrowser("https://discord.com/invite/VeV2MKDtnT")
            R.id.nav_vk -> openLinkInBrowser("https://vk.com/somniumcraft")
            R.id.nav_settingsActivity -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .commit()
    }

    private fun openLinkInBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}