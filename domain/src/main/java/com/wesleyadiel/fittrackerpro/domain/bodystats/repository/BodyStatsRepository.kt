package com.wesleyadiel.fittrackerpro.domain.bodystats.repository

import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import kotlinx.coroutines.flow.Flow

interface BodyStatsRepository {
    fun getAllBodyStats(): Flow<List<BodyStats>>
    suspend fun getBodyStatsById(id: Long): BodyStats?
    suspend fun addBodyStats(bodyStats: BodyStats)
    suspend fun deleteBodyStats(id: Long)
}