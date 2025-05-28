package com.wesleyadiel.fitnesstrackpro.data

import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import javax.inject.Inject

class BodyStatsRepositoryImpl @Inject constructor() : BodyStatsRepository {

    private val fakeStats = MutableStateFlow<List<BodyStats>>(listOf(
        BodyStats(
            id = 1L,
            date = LocalDate.now().toEpochDay(),
            weightKg = 73.5,
            bodyFatPercentage = 16.2,
            visceralFat = 9.0,
            skeletalMuscleMassKg = 32.1,
            photoUri = null
        ),
        BodyStats(
            id = 2L,
            date = LocalDate.ofYearDay(2025, 35).toEpochDay(), // random date, 04/02/2025
            weightKg = 75.2,
            bodyFatPercentage = 17.0,
            visceralFat = 10.0,
            skeletalMuscleMassKg = 31.8,
            photoUri = null
        )
    ))


    override fun getAllBodyStats(): Flow<List<BodyStats>> = fakeStats.asStateFlow()

    override suspend fun getBodyStatsById(id: Long): BodyStats? {
        return fakeStats.value.find { it.id == id }
    }

    override suspend fun addBodyStats(bodyStats: BodyStats) {
        fakeStats.update { current ->
            current + bodyStats.copy(id = (current.maxOfOrNull { it.id } ?: 0L) + 1)
        }
    }

    override suspend fun deleteBodyStats(id: Long) {
        fakeStats.update { current ->
            current.filterNot { it.id == id }
        }
    }
}