package com.example.somniumapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.somniumapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomView: BottomNavigationView
    private lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.app_name, R.string.app_name)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
        binding.bottomNavView.background = null

        binding.bottomNavView.setOnItemSelectedListener{ item ->
            when(item.itemId){
                R.id.bottom_homeFragment -> replaceFragment(Home())
                R.id.bottom_settingsFragment -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                    item.setCheckable(false);
                }
                R.id.bottom_searchFragment -> replaceFragment(Search())
            }
            true
        }

        toolbar = findViewById(R.id.toolbar)

        drawerLayout = binding.drawerLayout
        navView = binding.navView
        bottomView= binding.bottomNavView
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{
        when(item.itemId){
            R.id.nav_faqFragment -> replaceFragment(Faq())
            R.id.nav_gameplayFragment -> replaceFragment(Gameplay())
            R.id.nav_economyFragment -> replaceFragment(Economy())
            R.id.nav_donateFragment -> replaceFragment(Donate())
            R.id.nav_otherFragment -> replaceFragment(Other())
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .commit()
    }
}

