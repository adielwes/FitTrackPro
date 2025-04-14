package com.wesleyadiel.fittrackerpro.presentation.bodystats.state

import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats

data class BodyStatsUiState(
    val bodyStats: List<BodyStats> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)