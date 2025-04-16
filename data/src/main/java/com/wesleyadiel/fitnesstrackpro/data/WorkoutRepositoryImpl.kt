package com.wesleyadiel.fitnesstrackpro.data

import com.wesleyadiel.fittrackerpro.domain.workout.model.AdvancedTechnique
import com.wesleyadiel.fittrackerpro.domain.workout.model.Exercise
import com.wesleyadiel.fittrackerpro.domain.workout.model.ExerciseType
import com.wesleyadiel.fittrackerpro.domain.workout.model.Series
import com.wesleyadiel.fittrackerpro.domain.workout.model.Workout
import com.wesleyadiel.fittrackerpro.domain.workout.model.WorkoutPlan
import com.wesleyadiel.fittrackerpro.domain.workout.repository.WorkoutRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class WorkoutRepositoryImpl  @Inject constructor() : WorkoutRepository {

    private val fakeWorkouts = MutableStateFlow<List<Workout>>(listOf(
        Workout(
            id = 1L,
            date = System.currentTimeMillis(),
            durationMinutes = 60,
            plan = WorkoutPlan(
                id = 1L,
                goal = "Upper body hypertrophy",
                series = listOf(
                    Series(
                        id = 1L,
                        exercise = Exercise(
                            id = 1L,
                            name = "Flat bench press",
                            description = "Chest exercise using a barbell.",
                            type = ExerciseType.HYPERTROPHY
                        ),
                        repetition = "4x10",
                        weightKg = 40,
                        restTimeSec = 60,
                        totalTimeMin = 10,
                        technique = AdvancedTechnique(
                            name = "Drop-set",
                            description = "Gradually reducing weight without rest."
                        )
                    ),
                    Series(
                        id = 2L,
                        exercise = Exercise(
                            id = 2L,
                            name = "Bent-over row",
                            description = "Back exercise using a barbell.",
                            type = ExerciseType.STRENGTH
                        ),
                        repetition = "3x8",
                        weightKg = 50,
                        restTimeSec = 90,
                        totalTimeMin = 12,
                        technique = AdvancedTechnique(
                            name = "Negative reps",
                            description = "Focus on the eccentric phase of the movement."
                        )
                    )
                )
            )
        )
    ))

    override fun getAllWorkouts(): Flow<List<Workout>> = fakeWorkouts.asStateFlow()

    override suspend fun getWorkoutById(id: Long): Workout? {
        return fakeWorkouts.value.find { it.id == id }
    }

    override suspend fun addWorkout(workout: Workout) {
        fakeWorkouts.update { current ->
            current + workout.copy(id = (current.maxOfOrNull { it.id } ?: 0L) + 1)
        }
    }

    override suspend fun deleteWorkout(id: Long) {
        fakeWorkouts.update { current ->
            current.filterNot { it.id == id }
        }
    }
}