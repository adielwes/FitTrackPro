package com.wesleyadiel.fittrackerpro.domain.bioimpedance.extractor

import android.graphics.Bitmap
import com.wesleyadiel.fittrackerpro.domain.bioimpedance.model.BioImpedanceData

interface BioImpedanceExtractor {
    suspend fun extractFromImage(image: Bitmap): BioImpedanceData
}