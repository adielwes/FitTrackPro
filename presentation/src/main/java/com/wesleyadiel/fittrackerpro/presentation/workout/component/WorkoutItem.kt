package com.wesleyadiel.fittrackerpro.presentation.workout.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wesleyadiel.fittrackerpro.domain.workout.model.Workout

@Composable
fun WorkoutItem(workout: Workout, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = workout.plan.goal)
            Text(text = "Duration: ${workout.durationMinutes} min")
            Text(text = "Date: ${workout.date}")
            Text(text = "Series size: ${workout.plan.series.size}")
        }
    }
}