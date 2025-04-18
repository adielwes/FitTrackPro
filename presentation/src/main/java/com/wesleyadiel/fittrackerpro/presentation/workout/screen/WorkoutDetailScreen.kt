package com.wesleyadiel.fittrackerpro.presentation.workout.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.IconButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WorkoutDetailScreen(
    workoutId: Long?,
    onBackClick: () -> Unit
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Workout Details", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                modifier = Modifier.padding(WindowInsets.statusBars.asPaddingValues())
            )
        }
    ) { padding ->
        Box(modifier = Modifier
            .padding(padding)
            .fillMaxSize()
        ) {
            Text(
                text = "Detail screen of workout ID = $workoutId",
                modifier = Modifier.run { padding(16.dp) }
            )
        }
    }
}
