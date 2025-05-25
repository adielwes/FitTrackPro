package com.wesleyadiel.fittrackerpro.presentation.bodystats.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.wesleyadiel.fittrackerpro.presentation.bodystats.event.RegisterBodyStatsEvent
import com.wesleyadiel.fittrackerpro.presentation.bodystats.state.RegisterBodyStatsUiState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun RegisterBodyStatsScreen(
    uiState: RegisterBodyStatsUiState,
    onEvent: (RegisterBodyStatsEvent) -> Unit,
    onSave: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Register Body Statistics") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        modifier = Modifier.padding(
            WindowInsets.statusBars
                .asPaddingValues()
        ),
        bottomBar = {
            Button(
                onClick = onSave,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Salvar Progresso")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = LocalDate.ofEpochDay(uiState.date)
                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                onValueChange = { /* to call DatePicker here */ },
                readOnly = true,
                label = { Text("Data") },
                trailingIcon = {
                    Icon(Icons.Default.DateRange, contentDescription = "Select Data")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.weight,
                onValueChange = { onEvent(RegisterBodyStatsEvent.OnWeightChanged(it)) },
                label = { Text("Weight (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.bodyFatPercentage,
                onValueChange = { onEvent(RegisterBodyStatsEvent.OnBodyFatChanged(it)) },
                label = { Text("% Fat") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.visceralFat,
                onValueChange = { onEvent(RegisterBodyStatsEvent.OnVisceralFatChanged(it)) },
                label = { Text("Visceral Fat") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = uiState.skeletalMuscle,
                onValueChange = { onEvent(RegisterBodyStatsEvent.OnSkeletalMuscleChanged(it)) },
                label = { Text("Skeletal Muscle Mass (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )


            if (uiState.photoUri == null) {
                OutlinedButton(
                    onClick = { onEvent(RegisterBodyStatsEvent.OnAddPhotoClicked) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Image, contentDescription = "Add Photo")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Add Photo")
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    AsyncImage(
                        model = uiState.photoUri,
                        contentDescription = "Progress Picture",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                    OutlinedButton(
                        onClick = { onEvent(RegisterBodyStatsEvent.OnRemovePhotoClicked) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Remove Photo")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Remove Photo")
                    }
                }
            }
        }
    }
}

@Composable
fun AsyncImage(model: String, contentDescription: String, modifier: Modifier, contentScale: ContentScale) {
    TODO("Not yet implemented")
}