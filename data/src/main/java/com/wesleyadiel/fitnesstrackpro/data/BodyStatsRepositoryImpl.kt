package com.wesleyadiel.fitnesstrackpro.data

import android.net.Uri
import com.wesleyadiel.fitnesstrackpro.data.image.ImageStorageManager
import com.wesleyadiel.fitnesstrackpro.data.mapper.toDomain
import com.wesleyadiel.fitnesstrackpro.data.mapper.toEntity
import com.wesleyadiel.fitnesstrackpro.database.bodystats.BodyStatsDao
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BodyStatsRepositoryImpl @Inject constructor(
    private val dao: BodyStatsDao,
    private val imageStorageManager: ImageStorageManager
) : BodyStatsRepository {

    override fun getAllBodyStats(): Flow<List<BodyStats>> = dao.getAll().map {
        it.map { it.toDomain() }
    }

    override suspend fun getBodyStatsById(id: Long): BodyStats? = dao.getById(id)?.toDomain()

    override suspend fun addBodyStats(bodyStats: BodyStats, imageUri: Uri?) {
        val savedPath = imageUri?.let { imageStorageManager.saveImageToInternalStorage(it) }
        val entity = bodyStats.copy(imageUri = savedPath).toEntity()
        dao.insert(entity)
    }

    override suspend fun deleteBodyStats(bodyStats: BodyStats) {
        imageStorageManager.deleteImageFromInternalStorage(bodyStats.imageUri)
        dao.delete(bodyStats.toEntity())
    }
}