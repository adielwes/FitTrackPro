package com.wesleyadiel.fitnesstrackpro.data.extractor

import android.graphics.Bitmap
import com.wesleyadiel.ai.GemmaVisionClient
import com.wesleyadiel.fitnesstrackpro.data.mapper.BioImpedanceDataParser
import com.wesleyadiel.fittrackerpro.domain.bioimpedance.extractor.BioImpedanceExtractor
import com.wesleyadiel.fittrackerpro.domain.bioimpedance.model.BioImpedanceData

/**
 * Implementation of BioImpedanceExtractor that uses a local LLM with vision capabilities
 * to extract body composition metrics from a photo of a bioimpedance report.
 */
class BioImpedanceExtractorImpl(
    private val gemmaClient: GemmaVisionClient
) : BioImpedanceExtractor {

    override suspend fun extractFromImage(image: Bitmap): BioImpedanceData {
        val prompt = """
            Extract the following values from this bioimpedance report image:
            - Weight (kg)
            - Body fat percentage (%)
            - Muscle mass (kg)
            - BMI

            Format the response clearly.
        """.trimIndent()

        val resultText = gemmaClient.infer(prompt, image)

        return BioImpedanceDataParser.parse(resultText)
    }
}
