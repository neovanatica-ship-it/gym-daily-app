package com.example.gymdaily.navigation
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.gymdaily.ui.screens.*
import com.example.gymdaily.ui.viewmodel.WorkoutViewModel
@Composable
fun NavGraph(vm: WorkoutViewModel = viewModel()) {
    val nav = rememberNavController()
    NavHost(nav, startDestination = "home") {
        composable("home") { HomeScreen(vm, { nav.navigate("add") }, { nav.navigate("history") }) }
        composable("add") { AddWorkoutScreen(vm, { nav.popBackStack() }) }
        composable("history") { HistoryScreen(vm, { nav.popBackStack() }) }
    }
}
