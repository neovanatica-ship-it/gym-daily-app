package com.example.gymdaily.ui.viewmodel
import android.app.Application
import androidx.lifecycle.*
import com.example.gymdaily.GymApplication
import com.example.gymdaily.data.Workout
import com.example.gymdaily.data.WorkoutRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Calendar
class WorkoutViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = (app as GymApplication).repository
    val allWorkouts = repo.allWorkouts.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val todayWorkouts = run {
        val cal = Calendar.getInstance().apply { set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0); set(Calendar.MILLISECOND, 0) }
        repo.getToday(cal.timeInMillis, cal.timeInMillis + 86400000).stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    }
    fun add(name: String, sets: Int, reps: Int, weight: Float, notes: String) {
        viewModelScope.launch { repo.insert(Workout(name = name, sets = sets, reps = reps, weight = weight, notes = notes, date = System.currentTimeMillis())) }
    }
    fun delete(w: Workout) { viewModelScope.launch { repo.delete(w) } }
}
