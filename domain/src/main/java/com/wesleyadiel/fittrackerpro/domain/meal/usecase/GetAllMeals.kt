package com.wesleyadiel.fittrackerpro.domain.meal.usecase

import com.wesleyadiel.fittrackerpro.domain.meal.model.Meal
import com.wesleyadiel.fittrackerpro.domain.meal.repository.MealRepository
import kotlinx.coroutines.flow.Flow

class GetAllMeals(private val repository: MealRepository) {

    operator fun invoke(): Flow<List<Meal>> = repository.getAllMeals()
}