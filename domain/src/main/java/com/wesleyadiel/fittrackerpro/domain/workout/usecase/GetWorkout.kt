package com.wesleyadiel.fittrackerpro.domain.workout.usecase

import com.wesleyadiel.fittrackerpro.domain.workout.model.Workout
import com.wesleyadiel.fittrackerpro.domain.workout.repository.WorkoutRepository

class GetWorkout(private val repository: WorkoutRepository) {
    suspend operator fun invoke(id: Long): Workout? = repository.getWorkoutById(id)
}