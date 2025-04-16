package com.wesleyadiel.fitnesstrackpro.data

import com.wesleyadiel.fittrackerpro.domain.meal.model.Meal
import com.wesleyadiel.fittrackerpro.domain.meal.model.MealType
import com.wesleyadiel.fittrackerpro.domain.meal.repository.MealRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor() : MealRepository {

    private val fakeMeals = MutableStateFlow<List<Meal>>(listOf(
        Meal(
            id = 1L,
            name = "Breakfast",
            date = System.currentTimeMillis(),
            calories = 350,
            protein = 20.0,
            carbs = 40.0,
            fat = 10.0,
            mealType = MealType.BREAKFAST
        ),
        Meal(
            id = 2L,
            name = "Lunch",
            date = System.currentTimeMillis(),
            calories = 700,
            protein = 35.0,
            carbs = 70.0,
            fat = 25.0,
            mealType = MealType.LUNCH
        )
    ))

    override fun getAllMeals(): Flow<List<Meal>> = fakeMeals.asStateFlow()

    override suspend fun addMeal(meal: Meal) {
        fakeMeals.update { current ->
            current + meal.copy(id = (current.maxOfOrNull { it.id } ?: 0L) + 1)
        }
    }

    override suspend fun deleteMeal(id: Long) {
        fakeMeals.update { current ->
            current.filterNot { it.id == id }
        }
    }

    override suspend fun getMealById(id: Long): Meal? {
        return fakeMeals.value.find { it.id == id }
    }
}