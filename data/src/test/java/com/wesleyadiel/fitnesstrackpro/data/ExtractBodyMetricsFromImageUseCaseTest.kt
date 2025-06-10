package com.wesleyadiel.fitnesstrackpro.data

import android.graphics.Bitmap
import com.wesleyadiel.fitnesstrackpro.data.extractor.BioImpedanceExtractorImpl
import com.wesleyadiel.fittrackerpro.domain.bioimpedance.usecase.ExtractBodyMetricsFromImageUseCase
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class ExtractBodyMetricsFromImageUseCaseTest {

    private val fakeClient = FakeGemmaClient()
    private val extractor = BioImpedanceExtractorImpl(fakeClient)
    private val useCase = ExtractBodyMetricsFromImageUseCase(extractor)

    @Test
    fun `use case should return parsed BioImpedanceData from image`() = runTest {
        val fakeBitmap = mock<Bitmap>()
        val result = useCase(fakeBitmap)

        assertEquals(80.0f, result.weight)
        assertEquals(20.0f, result.bodyFatPercent)
    }
}