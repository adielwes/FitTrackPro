package com.wesleyadiel.fittrackerpro.presentation.meal.screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MealDetailScreen(id: Long?) {
    Text(text = "Detail screen of meal ID = $id")

    val navController = rememberNavController()
    Button(onClick = { navController.popBackStack() }) {
        Text("Back")
    }
}