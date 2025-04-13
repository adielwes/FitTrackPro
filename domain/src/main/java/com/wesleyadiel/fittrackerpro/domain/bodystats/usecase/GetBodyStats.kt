package com.wesleyadiel.fittrackerpro.domain.bodystats.usecase

import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository

class GetBodyStats(private val repository: BodyStatsRepository) {

    suspend operator fun invoke(id: Long): BodyStats? = repository.getBodyStatsById(id)
}