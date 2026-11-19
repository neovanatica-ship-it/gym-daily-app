package com.example.gymdaily.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.gymdaily.ui.viewmodel.WorkoutViewModel
import java.text.SimpleDateFormat
import java.util.*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(vm: WorkoutViewModel, onAdd: () -> Unit, onHistory: () -> Unit) {
    val today by vm.todayWorkouts.collectAsState()
    Scaffold(topBar = { TopAppBar(title = { Text("Gym Harian") }, actions = { IconButton(onClick = onHistory) { Icon(Icons.Default.History, null) } }) },
        floatingActionButton = { FloatingActionButton(onClick = onAdd) { Icon(Icons.Default.Add, null) } }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
            Text("Latihan Hari Ini", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text(SimpleDateFormat("EEEE, dd MMM yyyy", Locale("id", "ID")).format(Date()), style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(16.dp))
            if (today.isEmpty()) Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Belum ada latihan.") }
            else LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) { items(today) { w -> Card(Modifier.fillMaxWidth()) { Column(Modifier.padding(12.dp)) { Text(w.name, fontWeight = FontWeight.Bold); Text("${w.sets} x ${w.reps} @ ${w.weight}kg") } } } }
        }
    }
}
