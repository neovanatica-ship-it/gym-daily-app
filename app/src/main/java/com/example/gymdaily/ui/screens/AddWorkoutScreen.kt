package com.example.gymdaily.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymdaily.ui.viewmodel.WorkoutViewModel
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWorkoutScreen(vm: WorkoutViewModel, onDone: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var sets by remember { mutableStateOf("3") }
    var reps by remember { mutableStateOf("10") }
    var weight by remember { mutableStateOf("20") }
    Scaffold(topBar = { TopAppBar(title = { Text("Tambah") }, navigationIcon = { IconButton(onClick = onDone) { Icon(Icons.Default.ArrowBack, null) } }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp).verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(name, { name = it }, label = { Text("Nama Latihan") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
            OutlinedTextField(sets, { sets = it.filter { c -> c.isDigit() } }, label = { Text("Set") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
            OutlinedTextField(reps, { reps = it.filter { c -> c.isDigit() } }, label = { Text("Reps") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
            OutlinedTextField(weight, { weight = it.filter { c -> c.isDigit() || c == "." } }, label = { Text("Beban (kg)") }, modifier = Modifier.fillMaxWidth(), singleLine = true)
            Button({ if (name.isNotBlank()) { vm.add(name, sets.toIntOrNull()?:0, reps.toIntOrNull()?:0, weight.toFloatOrNull()?:0f, ""); onDone() } }, Modifier.fillMaxWidth()) { Text("Simpan") }
        }
    }
}
