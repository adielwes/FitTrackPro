package com.wesleyadiel.fittrackerpro.presentation.meal.state

import com.wesleyadiel.fittrackerpro.domain.meal.model.Meal

data class MealUiState(
    val meals: List<Meal> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)