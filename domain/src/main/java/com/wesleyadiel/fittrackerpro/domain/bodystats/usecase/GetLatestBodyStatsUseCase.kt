package com.wesleyadiel.fittrackerpro.domain.bodystats.usecase

import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository

class GetLatestBodyStatsUseCase(
    private val repository: BodyStatsRepository
) {
    suspend operator fun invoke(): BodyStats? {
        return repository.getLatestBodyStats()
    }
}
