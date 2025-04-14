package com.wesleyadiel.fittrackerpro.presentation.bodystats.screen

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun BodyStatsDetailScreen(id: Long?) {
    Text(text = "Detail screen of body stats ID = $id")

    val navController = rememberNavController()
    Button(onClick = { navController.popBackStack() }) {
        Text("Back")
    }
}