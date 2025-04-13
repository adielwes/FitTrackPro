package com.wesleyadiel.fittrackerpro.domain.workout.model

data class Series(
    val id: Long,
    val exercise: Exercise,
    val repetition: String,
    val weightKg: Int,
    val restTimeSec: Int,
    val totalTimeMin: Int,
    val technique: AdvancedTechnique
)