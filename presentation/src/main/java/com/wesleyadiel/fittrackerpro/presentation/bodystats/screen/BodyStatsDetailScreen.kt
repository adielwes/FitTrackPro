package com.wesleyadiel.fittrackerpro.presentation.bodystats.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.wesleyadiel.fittrackerpro.presentation.bodystats.viewmodel.BodyStatsViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import androidx.core.net.toUri

@Composable
fun BodyStatsDetailScreen(
    id: Long?,
    onNavigateBack: () -> Unit
) {

    val viewModel: BodyStatsViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    val bodyStat = state.value.bodyStats.find { it.id == id }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Body Stats Detail") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "Go back")
                    }
                }
            )
        },
        modifier = Modifier.padding(
            WindowInsets.statusBars
                .asPaddingValues()
        ),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            if (bodyStat != null) {
                Text(
                    text = "Date: ${
                        LocalDate.ofEpochDay(bodyStat.date)
                            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    }",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text("Weight: ${bodyStat.weight} kg")
                Text("Body Fat: ${bodyStat.bodyFat}%")
                Text("Muscle Mass: ${bodyStat.skeletalMuscle} kg")
                Text("Visceral Fat: ${bodyStat.visceralFat}")

                bodyStat.imageUri?.let { uriString ->
                    val imageUri = uriString.toUri()
                    Spacer(modifier = Modifier.height(16.dp))
                    AsyncImage(
                        model = imageUri,
                        contentDescription = "Body Stats Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Fit
                    )
                }
            }else if (state.value.isLoading) {
                CircularProgressIndicator()
            } else {
                Text("Record not found.")
            }
        }
    }
}