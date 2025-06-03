package com.wesleyadiel.fitnesstrackpro.database.bodystats

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BodyStatsDao {
    @Query("SELECT * FROM body_stats ORDER BY date DESC")
    fun getAll(): Flow<List<BodyStatsEntity>>

    @Query("SELECT * FROM body_stats WHERE id = :id LIMIT 1")
    suspend fun getById(id: Long): BodyStatsEntity?

    @Query("SELECT * FROM body_stats ORDER BY date DESC LIMIT 1")
    suspend fun getLatestBodyStats(): BodyStatsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bodyStats: BodyStatsEntity)

    @Delete
    suspend fun delete(bodyStats: BodyStatsEntity)
}