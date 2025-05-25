package com.wesleyadiel.fittrackerpro.domain.bodystats.usecase

import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository

class DeleteBodyStatsUseCase(private val repository: BodyStatsRepository) {

    suspend operator fun invoke(bodyStats: BodyStats) = repository.deleteBodyStats(bodyStats.id)
}