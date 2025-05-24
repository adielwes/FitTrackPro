package com.wesleyadiel.fittrackerpro.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wesleyadiel.fittrackerpro.presentation.home.components.ProgressSummary
import com.wesleyadiel.fittrackerpro.presentation.home.components.WorkoutCard
import com.wesleyadiel.fittrackerpro.presentation.home.components.WorkoutPlanCard

@Composable
fun HomeScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.White,
            darkIcons = true
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                WindowInsets.statusBars
                    .asPaddingValues()
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Progresso físico
        ProgressSummary(
            weight = 73.0,
            bodyFat = 15.0,
            muscleMass = 35.0,
            onRegisterClick = { navController.navigate("bodyStats") },
            onHistoryClick = { navController.navigate("bodyStats") }
        )

        // Treino do dia
        WorkoutCard(
            workoutName = "Treino A",
            exercises = listOf("Agachamento 4x10", "Supino 4x10", "Remada 4x10"),
            onStartWorkout = { navController.navigate("workout") }
        )

        // Plano de treino
        WorkoutPlanCard(
            onEditPlan = { navController.navigate("workoutPlan") }
        )
    }
}