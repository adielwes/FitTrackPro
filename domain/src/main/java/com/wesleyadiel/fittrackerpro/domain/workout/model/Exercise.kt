package com.wesleyadiel.fittrackerpro.domain.workout.model

data class Exercise(
    val id: Long,
    val name: String,
    val description: String,
    val type: ExerciseType
)