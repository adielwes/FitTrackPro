package com.wesleyadiel.fittrackerpro.domain.bioimpedance.model

import java.time.LocalDate

data class BioImpedanceData(
    val weight: Float?,         // kg
    val bodyFatPercent: Float?, // %
    val muscleMass: Float?,     // kg
    val bmi: Float?,            // index
    val date: LocalDate,
    val imagePath: String? = null
)