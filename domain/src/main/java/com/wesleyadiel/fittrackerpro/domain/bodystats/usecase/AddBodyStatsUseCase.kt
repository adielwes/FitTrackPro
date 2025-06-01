package com.wesleyadiel.fittrackerpro.domain.bodystats.usecase

import android.net.Uri
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.repository.BodyStatsRepository

class AddBodyStatsUseCase(private val repository: BodyStatsRepository) {

    suspend operator fun invoke(bodyStats: BodyStats, imageUri: Uri?) =
        repository.addBodyStats(bodyStats, imageUri)
}