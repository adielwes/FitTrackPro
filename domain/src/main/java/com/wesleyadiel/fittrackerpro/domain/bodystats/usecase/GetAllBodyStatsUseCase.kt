package com.wesleyadiel.fittrackerpro.domain.bodystats.usecase

import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository
import kotlinx.coroutines.flow.Flow

class GetAllBodyStatsUseCase(private val repository: BodyStatsRepository) {

    operator fun invoke() : Flow<List<BodyStats>> = repository.getAllBodyStats()
}