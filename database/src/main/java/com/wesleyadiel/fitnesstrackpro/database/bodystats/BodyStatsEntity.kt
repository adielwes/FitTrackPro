package com.wesleyadiel.fitnesstrackpro.database.bodystats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "body_stats")
data class BodyStatsEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val weight: Double,
    val bodyFat: Double,
    val visceralFat: Double,
    val skeletalMuscle: Double,
    val date: Long,
    val imageUri: String? = null
)