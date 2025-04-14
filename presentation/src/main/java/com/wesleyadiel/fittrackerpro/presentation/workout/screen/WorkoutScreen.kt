package com.wesleyadiel.fittrackerpro.presentation.workout.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.wesleyadiel.fittrackerpro.presentation.workout.component.WorkoutItem
import com.wesleyadiel.fittrackerpro.presentation.workout.viewmodel.WorkoutViewModel

@Composable
fun WorkoutScreen(onNavigateToDetail: (Long) -> Unit) {
    val viewModel: WorkoutViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    LazyColumn {
        items(state.value.workouts) { workout ->
            WorkoutItem(
                workout,
                modifier = Modifier.clickable { onNavigateToDetail(workout.id) }
            )
        }
    }
}