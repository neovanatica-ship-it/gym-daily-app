package com.example.gymdaily.ui.theme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
private val LightColors = lightColorScheme(primary = Color(0xFFE53935), secondary = Color(0xFF1E88E5))
@Composable
fun GymDailyTheme(content: @Composable () -> Unit) { MaterialTheme(colorScheme = LightColors, content = content) }
