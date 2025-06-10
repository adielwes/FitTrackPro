package com.wesleyadiel.fitnesstrackpro.data

import com.wesleyadiel.fitnesstrackpro.data.mapper.BioImpedanceDataParser
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test

class BioImpedanceDataParserTest {

    @Test
    fun `parse should extract all fields from well-formed text`() {
        val text = """
            Weight: 70.5 kg
            Body fat percentage: 16.2%
            Muscle mass: 55.4 kg
            BMI: 22.9
        """.trimIndent()

        val result = BioImpedanceDataParser.parse(text)

        assertEquals(70.5f, result.weight)
        assertEquals(16.2f, result.bodyFatPercent)
        assertEquals(55.4f, result.muscleMass)
        assertEquals(22.9f, result.bmi)
    }

    @Test
    fun `parse should return nulls for missing values`() {
        val text = """
            Weight: 68.0 kg
        """.trimIndent()

        val result = BioImpedanceDataParser.parse(text)

        assertEquals(68.0f, result.weight)
        assertNull(result.bodyFatPercent)
        assertNull(result.muscleMass)
        assertNull(result.bmi)
    }
}
