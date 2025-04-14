package com.wesleyadiel.fittrackerpro.domain.workout.model

data class Workout(
    val id: Long,
    val date: Long,
    val plan: WorkoutPlan,
    val durationMinutes: Long
)