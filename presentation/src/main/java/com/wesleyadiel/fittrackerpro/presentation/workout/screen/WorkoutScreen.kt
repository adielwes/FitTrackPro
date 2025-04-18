package com.wesleyadiel.fittrackerpro.presentation.workout.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wesleyadiel.fittrackerpro.presentation.workout.component.WorkoutItem
import com.wesleyadiel.fittrackerpro.presentation.workout.state.WorkoutUiState
import com.wesleyadiel.fittrackerpro.presentation.workout.viewmodel.WorkoutViewModel

@Composable
fun WorkoutScreen(onNavigateToDetail: (Long) -> Unit) {

    val systemUiController = rememberSystemUiController()
    val viewModel: WorkoutViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Workouts") },
                modifier = Modifier.padding(WindowInsets.statusBars.asPaddingValues())
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            WorkoutCard(state, onNavigateToDetail)
        }
    }
}

@Composable
private fun WorkoutCard(
    state: State<WorkoutUiState>,
    onNavigateToDetail: (Long) -> Unit
) {
    LazyColumn {
        items(state.value.workouts) { workout ->
            WorkoutItem(
                workout,
                modifier = Modifier.clickable { onNavigateToDetail(workout.id) }
            )
        }
    }
}