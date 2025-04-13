package com.wesleyadiel.fittrackerpro.domain.workout.repository

import com.wesleyadiel.fittrackerpro.domain.workout.model.Workout
import kotlinx.coroutines.flow.Flow

interface WorkoutRepository {
    fun getAllWorkouts(): Flow<List<Workout>>
    suspend fun getWorkoutById(id: Long): Workout?
    suspend fun addWorkout(workout: Workout)
    suspend fun deleteWorkout(id: Long)
}