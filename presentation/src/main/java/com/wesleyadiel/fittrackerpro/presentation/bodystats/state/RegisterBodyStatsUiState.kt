package com.wesleyadiel.fittrackerpro.presentation.bodystats.state

data class RegisterBodyStatsUiState(
    val date: Long = 0,
    val weight: String = "",
    val bodyFatPercentage: String = "",
    val visceralFat: String = "",
    val skeletalMuscle: String = "",
    val photoUri: String? = null
)