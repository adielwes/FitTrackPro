package com.wesleyadiel.fittrackerpro.domain.workout.usecase

import com.wesleyadiel.fittrackerpro.domain.model.workout.Workout
import com.wesleyadiel.fittrackerpro.domain.repository.WorkoutRepository

class AddWorkout(private val repository: WorkoutRepository) {

    suspend operator fun invoke(workout: Workout) = repository.addWorkout(workout)
}