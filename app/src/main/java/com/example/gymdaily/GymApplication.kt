package com.example.gymdaily
import android.app.Application
import com.example.gymdaily.data.WorkoutDatabase
import com.example.gymdaily.data.WorkoutRepository
class GymApplication : Application() {
    val database by lazy { WorkoutDatabase.getDatabase(this) }
    val repository by lazy { WorkoutRepository(database.workoutDao()) }
}
