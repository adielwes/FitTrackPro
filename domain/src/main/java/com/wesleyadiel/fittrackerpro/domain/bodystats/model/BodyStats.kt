package com.wesleyadiel.fittrackerpro.domain.bodystats.model

data class BodyStats(
    val id: Long,
    val date: Long,
    val weight: Double,
    val bodyFat: Double,
    val visceralFat: Double,
    val skeletalMuscle: Double,
    val imageUri: String? = null
)