package com.wesleyadiel.fittrackerpro.domain.bodystats.repository

import android.net.Uri
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import kotlinx.coroutines.flow.Flow

interface BodyStatsRepository {
    fun getAllBodyStats(): Flow<List<BodyStats>>
    suspend fun getBodyStatsById(id: Long): BodyStats?
    suspend fun addBodyStats(bodyStats: BodyStats, imageUri: Uri?)
    suspend fun deleteBodyStats(bodyStats: BodyStats)
}