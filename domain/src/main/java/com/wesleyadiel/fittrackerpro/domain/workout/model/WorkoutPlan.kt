package com.wesleyadiel.fittrackerpro.domain.workout.model

data class WorkoutPlan(
    val id: Long,
    val goal: String,
    val series: List<Series>
)
