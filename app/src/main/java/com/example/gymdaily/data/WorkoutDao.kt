package com.example.gymdaily.data
import androidx.room.*
import kotlinx.coroutines.flow.Flow
@Dao
interface WorkoutDao {
    @Insert suspend fun insert(workout: Workout)
    @Delete suspend fun delete(workout: Workout)
    @Query("SELECT * FROM workouts ORDER BY date DESC") fun getAllWorkouts(): Flow<List<Workout>>
    @Query("SELECT * FROM workouts WHERE date >= :start AND date < :end ORDER BY date DESC") fun getToday(start: Long, end: Long): Flow<List<Workout>>
}
