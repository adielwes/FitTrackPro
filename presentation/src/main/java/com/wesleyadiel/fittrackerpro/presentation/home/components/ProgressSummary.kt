package com.wesleyadiel.fittrackerpro.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats

@Composable
fun ProgressSummary(
    bodyStats: State<BodyStats?>,
    onRegisterClick: () -> Unit,
    onHistoryClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Physical Progress", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))

            if (bodyStats.value != null) {
                Text("Weight: ${bodyStats.value?.weight}kg")
                Text("Body Fat: ${bodyStats.value?.bodyFat}%")
                Text("Skeletal Muscular Mass: ${bodyStats.value?.skeletalMuscle}kg")
            } else {
                Text("No body stats registered.")
            }

            Spacer(Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = onRegisterClick) {
                    Text("Register Progress")
                }
                OutlinedButton(
                    onClick = onHistoryClick,
                    enabled = bodyStats.value != null
                ) {
                    Text("See History")
                }
            }
        }
    }
}