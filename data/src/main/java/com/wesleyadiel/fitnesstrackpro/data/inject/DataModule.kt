package com.wesleyadiel.fitnesstrackpro.data.inject

import com.wesleyadiel.fitnesstrackpro.data.BodyStatsRepositoryImpl
import com.wesleyadiel.fitnesstrackpro.data.MealRepositoryImpl
import com.wesleyadiel.fitnesstrackpro.data.WorkoutRepositoryImpl
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository
import com.wesleyadiel.fittrackerpro.domain.meal.repository.MealRepository
import com.wesleyadiel.fittrackerpro.domain.workout.repository.WorkoutRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindBodyStatsRepository(
        impl: BodyStatsRepositoryImpl
    ): BodyStatsRepository

    @Binds
    @Singleton
    abstract fun bindMealRepository(
        impl: MealRepositoryImpl
    ): MealRepository

    @Binds
    @Singleton
    abstract fun bindWorkoutRepository(
        impl: WorkoutRepositoryImpl
    ): WorkoutRepository
}