package com.wesleyadiel.fittrackerpro.domain.meal.usecase

import com.wesleyadiel.fittrackerpro.domain.meal.model.Meal
import com.wesleyadiel.fittrackerpro.domain.meal.repository.MealRepository

class GetMeal(private val repository: MealRepository) {

    suspend operator fun invoke(id: Long): Meal? = repository.getMealById(id)
}