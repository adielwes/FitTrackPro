package com.wesleyadiel.fittrackerpro.domain.workout.usecase

import com.wesleyadiel.fittrackerpro.domain.workout.model.Workout
import com.wesleyadiel.fittrackerpro.domain.workout.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow

class GetAllWorkouts(private val repository: WorkoutRepository) {
    operator fun invoke(): Flow<List<Workout>> = repository.getAllWorkouts()
}