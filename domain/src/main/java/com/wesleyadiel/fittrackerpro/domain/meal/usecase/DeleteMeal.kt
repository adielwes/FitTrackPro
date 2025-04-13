package com.wesleyadiel.fittrackerpro.domain.meal.usecase

import com.wesleyadiel.fittrackerpro.domain.meal.model.Meal
import com.wesleyadiel.fittrackerpro.domain.meal.repository.MealRepository

class DeleteMeal(private val repository: MealRepository) {

    suspend operator fun invoke(meal: Meal) = repository.deleteMeal(meal.id)
}