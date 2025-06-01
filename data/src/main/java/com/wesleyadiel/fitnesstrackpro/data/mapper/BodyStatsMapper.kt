package com.wesleyadiel.fitnesstrackpro.data.mapper

import com.wesleyadiel.fitnesstrackpro.database.bodystats.BodyStatsEntity
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats

fun BodyStatsEntity.toDomain(): BodyStats {
    return BodyStats(
        id = id,
        weight = weight,
        bodyFat = bodyFat,
        visceralFat = visceralFat,
        skeletalMuscle = skeletalMuscle,
        date = date,
        imageUri = imageUri
    )
}

fun BodyStats.toEntity(): BodyStatsEntity {
    return BodyStatsEntity(
        id = id,
        weight = weight,
        bodyFat = bodyFat,
        visceralFat = visceralFat,
        skeletalMuscle = skeletalMuscle,
        date = date,
        imageUri = imageUri
    )
}