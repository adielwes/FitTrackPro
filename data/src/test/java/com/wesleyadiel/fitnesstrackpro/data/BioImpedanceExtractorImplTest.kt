package com.wesleyadiel.fitnesstrackpro.data

import android.graphics.Bitmap
import com.wesleyadiel.ai.GemmaVisionClient
import com.wesleyadiel.fitnesstrackpro.data.extractor.BioImpedanceExtractorImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class FakeGemmaClient : GemmaVisionClient {
    override suspend fun infer(prompt: String, image: Bitmap): String {
        return """
            Weight: 80.0 kg
            Body fat percentage: 20.0%
            Muscle mass: 60.0 kg
            BMI: 24.7
        """.trimIndent()
    }
}

class BioImpedanceExtractorImplTest {

    private val fakeClient = FakeGemmaClient()
    private val extractor = BioImpedanceExtractorImpl(fakeClient)

    @Test
    fun `extractFromImage should return expected BioImpedanceData`() = runTest {
        val fakeBitmap = mock<Bitmap>()
        val result = extractor.extractFromImage(fakeBitmap)

        assertEquals(80.0f, result.weight)
        assertEquals(20.0f, result.bodyFatPercent)
        assertEquals(60.0f, result.muscleMass)
        assertEquals(24.7f, result.bmi)
    }
}