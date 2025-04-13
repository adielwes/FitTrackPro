package com.wesleyadiel.fittrackerpro.domain.meal.repository

import com.wesleyadiel.fittrackerpro.domain.meal.model.Meal
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    fun getAllMeals(): Flow<List<Meal>>
    suspend fun addMeal(meal: Meal)
    suspend fun deleteMeal(id: Long)
    suspend fun getMealById(id: Long): Meal?
}