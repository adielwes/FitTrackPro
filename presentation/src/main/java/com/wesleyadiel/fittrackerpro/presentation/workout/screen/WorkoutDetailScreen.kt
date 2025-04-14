package com.wesleyadiel.fittrackerpro.presentation.workout.screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun WorkoutDetailScreen(id: Long?) {
    Text(text = "Detail screen of workout ID = $id")

    val navController = rememberNavController()
    Button(onClick = { navController.popBackStack() }) {
        Text("Back")
    }
}