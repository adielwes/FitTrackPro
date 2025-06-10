package com.wesleyadiel.fittrackerpro.domain.bioimpedance.usecase

import android.graphics.Bitmap
import com.wesleyadiel.fittrackerpro.domain.bioimpedance.model.BioImpedanceData
import com.wesleyadiel.fittrackerpro.domain.bioimpedance.extractor.BioImpedanceExtractor

class ExtractBodyMetricsFromImageUseCase(
    private val extractor: BioImpedanceExtractor
) {
    suspend operator fun invoke(image: Bitmap): BioImpedanceData {
        return extractor.extractFromImage(image)
    }
}