package com.wesleyadiel.fittrackerpro.presentation.inject

import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository
import com.wesleyadiel.fittrackerpro.domain.bodystats.usecase.AddBodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.usecase.DeleteBodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.usecase.GetAllBodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.usecase.GetBodyStats
import com.wesleyadiel.fittrackerpro.domain.meal.repository.MealRepository
import com.wesleyadiel.fittrackerpro.domain.meal.usecase.AddMeal
import com.wesleyadiel.fittrackerpro.domain.meal.usecase.DeleteMeal
import com.wesleyadiel.fittrackerpro.domain.meal.usecase.GetAllMeals
import com.wesleyadiel.fittrackerpro.domain.meal.usecase.GetMeal
import com.wesleyadiel.fittrackerpro.domain.workout.repository.WorkoutRepository
import com.wesleyadiel.fittrackerpro.domain.workout.usecase.AddWorkout
import com.wesleyadiel.fittrackerpro.domain.workout.usecase.DeleteWorkout
import com.wesleyadiel.fittrackerpro.domain.workout.usecase.GetAllWorkouts
import com.wesleyadiel.fittrackerpro.domain.workout.usecase.GetWorkout
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetAllBodyStats(
        repository: BodyStatsRepository
    ): GetAllBodyStats = GetAllBodyStats(repository)

    @Provides
    fun provideGetBodyStatsById(
        repository: BodyStatsRepository
    ): GetBodyStats = GetBodyStats(repository)

    @Provides
    fun provideAddBodyStats(
        repository: BodyStatsRepository
    ): AddBodyStats = AddBodyStats(repository)

    @Provides
    fun provideDeleteBodyStats(
        repository: BodyStatsRepository
    ): DeleteBodyStats = DeleteBodyStats(repository)

    @Provides
    fun provideGetAllMeals(
        repository: MealRepository
    ): GetAllMeals = GetAllMeals(repository)

    @Provides
    fun provideGetMealById(
        repository: MealRepository
    ): GetMeal = GetMeal(repository)

    @Provides
    fun provideAddMeal(
        repository: MealRepository
    ): AddMeal = AddMeal(repository)

    @Provides
    fun provideDeleteMeal(
        repository: MealRepository
    ): DeleteMeal = DeleteMeal(repository)

    @Provides
    fun provideGetAllWorkouts(
        repository: WorkoutRepository
    ): GetAllWorkouts = GetAllWorkouts(repository)

    @Provides
    fun provideGetWorkoutById(
        repository: WorkoutRepository
    ): GetWorkout = GetWorkout(repository)

    @Provides
    fun provideAddWorkout(
        repository: WorkoutRepository
    ): AddWorkout = AddWorkout(repository)

    @Provides
    fun provideDeleteWorkout(
        repository: WorkoutRepository
    ): DeleteWorkout = DeleteWorkout(repository)
}