package com.wesleyadiel.fittrackerpro.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WorkoutCard(
    workoutName: String,
    exercises: List<String>,
    onStartWorkout: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Today's Routine: $workoutName", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            exercises.forEach { exercise ->
                Text("• $exercise")
            }
            Spacer(Modifier.height(8.dp))
            Button(onClick = onStartWorkout) {
                Text("Start Workout")
            }
        }
    }
}