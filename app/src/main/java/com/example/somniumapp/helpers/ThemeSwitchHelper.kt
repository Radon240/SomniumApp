import android.content.SharedPreferences
import com.example.somniumapp.R

object ThemeHelper {
    fun setThemeOfApp(sharedPrefs: SharedPreferences): Int {
        return when (sharedPrefs.getString("theme_preference", "light")) {
            "original" -> R.style.AppTheme
            "green" -> R.style.AppTheme_Holo_green_dark
            "red" -> R.style.AppTheme_Red
            "purple" -> R.style.AppTheme_Violet
            "grey" -> R.style.AppTheme_Grey
            else -> R.style.AppTheme
        }
    }
}