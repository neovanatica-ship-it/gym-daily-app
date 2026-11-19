package com.example.gymdaily.data
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "workouts")
data class Workout(@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String, val sets: Int, val reps: Int, val weight: Float, val notes: String = "", val date: Long)
