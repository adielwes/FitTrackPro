package com.wesleyadiel.fittrackerpro.domain.bodystats.model

data class BodyStats(
    val id: Long,
    val date: Long,
    val weightKg: Double,
    val bodyFatPercentage: Double,
    val visceralFat: Double,
    val skeletalMuscleMasskg: Double,
    val photoPath: String? = null
)