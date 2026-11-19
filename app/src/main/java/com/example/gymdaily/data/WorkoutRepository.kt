package com.example.gymdaily.data
import kotlinx.coroutines.flow.Flow
class WorkoutRepository(private val dao: WorkoutDao) {
    val allWorkouts: Flow<List<Workout>> = dao.getAllWorkouts()
    fun getToday(start: Long, end: Long): Flow<List<Workout>> = dao.getToday(start, end)
    suspend fun insert(w: Workout) = dao.insert(w)
    suspend fun delete(w: Workout) = dao.delete(w)
}
