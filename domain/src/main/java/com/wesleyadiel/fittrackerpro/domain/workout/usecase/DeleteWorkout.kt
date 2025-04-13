package com.wesleyadiel.fittrackerpro.domain.workout.usecase

import com.wesleyadiel.fittrackerpro.domain.model.workout.Workout
import com.wesleyadiel.fittrackerpro.domain.repository.WorkoutRepository

class DeleteWorkout(private val repository: WorkoutRepository) {

    suspend operator fun invoke(workout: Workout) = repository.deleteWorkout(workout.id)
}