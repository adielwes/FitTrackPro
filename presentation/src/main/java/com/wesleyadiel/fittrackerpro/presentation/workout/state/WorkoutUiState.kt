package com.wesleyadiel.fittrackerpro.presentation.workout.state

import com.wesleyadiel.fittrackerpro.domain.workout.model.Workout

data class WorkoutUiState(
    val workouts: List<Workout> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)