package com.wesleyadiel.fittrackerpro.domain.workout.usecase

import com.wesleyadiel.fittrackerpro.domain.model.workout.Workout
import com.wesleyadiel.fittrackerpro.domain.repository.WorkoutRepository

class GetWorkout(private val repository: WorkoutRepository) {
    suspend operator fun invoke(id: Long): Workout? = repository.getWorkoutById(id)
}