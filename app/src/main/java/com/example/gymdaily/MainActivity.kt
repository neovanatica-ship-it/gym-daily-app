package com.example.gymdaily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gymdaily.navigation.NavGraph
import com.example.gymdaily.ui.theme.GymDailyTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { GymDailyTheme { NavGraph() } }
    }
}
