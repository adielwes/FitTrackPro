package com.wesleyadiel.fittrackerpro.presentation.bodystats.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun BodyStatsItem(bodyStats: BodyStats, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
        .fillMaxWidth()
        .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Date: ${
                LocalDate.ofEpochDay(bodyStats.date)
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            }")
            Text(text = "Weight: ${bodyStats.weight} kg")
            Text(text = "Muscle mass: ${bodyStats.skeletalMuscle} kg")
            Text(text = "Body fat: ${bodyStats.bodyFat}%")
            Text(text = "Visceral fat: ${bodyStats.visceralFat}")
        }
    }
}