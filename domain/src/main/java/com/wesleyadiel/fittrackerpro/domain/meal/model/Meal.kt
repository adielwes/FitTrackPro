package com.wesleyadiel.fittrackerpro.domain.meal.model

data class Meal(
    val id: Long,
    val name: String,
    val date: Long,
    val calories: Int,
    val protein: Double,
    val carbs: Double,
    val fat: Double,
    val mealType: MealType
)