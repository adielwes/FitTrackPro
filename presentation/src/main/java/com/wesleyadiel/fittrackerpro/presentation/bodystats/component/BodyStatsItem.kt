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

@Composable
fun BodyStatsItem(bodyStats: BodyStats, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
        .fillMaxWidth()
        .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Date: ${bodyStats.date}")
            Text(text = "Weight: ${bodyStats.weightKg} kg")
            Text(text = "Muscle mass: ${bodyStats.skeletalMuscleMasskg} kg")
            Text(text = "Body fat: ${bodyStats.bodyFatPercentage}%")
            Text(text = "Visceral fat: ${bodyStats.visceralFat}")
        }
    }
}