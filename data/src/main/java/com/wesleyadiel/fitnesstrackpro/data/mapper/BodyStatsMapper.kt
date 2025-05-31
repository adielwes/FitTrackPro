package com.wesleyadiel.fitnesstrackpro.data.mapper

import com.wesleyadiel.fitnesstrackpro.database.bodystats.BodyStatsEntity
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats

fun BodyStatsEntity.toDomain(): BodyStats {
    return BodyStats(
        id = id,
        weightKg = weight,
        bodyFatPercentage = bodyFat,
        visceralFat = visceralFat,
        skeletalMuscleMassKg = skeletalMuscle,
        date = date
    )
}

fun BodyStats.toEntity(): BodyStatsEntity {
    return BodyStatsEntity(
        id = id,
        weight = weightKg,
        bodyFat = bodyFatPercentage,
        visceralFat = visceralFat,
        skeletalMuscle = skeletalMuscleMassKg,
        date = date
    )
}