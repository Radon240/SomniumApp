package com.example.somniumapp

import ArticlesByCategoryFragment
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.somniumapp.databinding.ActivityMainBinding
import com.example.somniumapp.features.article.ArticleRepository
import com.example.somniumapp.features.category.CategoryRepository
import com.example.somniumapp.features.category.model.GetCategoriesResponse
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.runBlocking
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var sharedPreferences: SharedPreferences

    private val categoryRepository: CategoryRepository by inject()

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

        val categories = runBlocking {
            categoryRepository.getCategories()
        }

        navView.menu.getItem(1).subMenu!!.clear()

        categories.data.forEach{ element ->
            navView.menu.getItem(1).subMenu!!.add(element.name).apply {
                this.contentDescription = element.id
            }
        }

        val category = intent.getStringExtra("category")
        if (category == null) {
            replaceFragment(Home())
            supportActionBar?.title = "Главная"
        } else {
            replaceFragment(ArticlesByCategoryFragment(category))
        }
    }

    override fun onRestart() {
        super.onRestart()
        recreate()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean{

        when(item.itemId){
            R.id.nav_home -> replaceFragment(Home())


            R.id.nav_dynMap -> openLinkInBrowser("https://map.scmc.dev/")
            R.id.nav_discordLink -> openLinkInBrowser("https://discord.com/invite/VeV2MKDtnT")
            R.id.nav_vk -> openLinkInBrowser("https://vk.com/somniumcraft")
            R.id.nav_settingsActivity -> {
                intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        if(item.contentDescription != null){
            replaceFragment(ArticlesByCategoryFragment(item.contentDescription.toString()))
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