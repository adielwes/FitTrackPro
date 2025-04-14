package com.wesleyadiel.fittrackerpro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.wesleyadiel.fittrackerpro.presentation.bodystats.screen.BodyStatsDetailScreen
import com.wesleyadiel.fittrackerpro.presentation.bodystats.screen.BodyStatsScreen
import com.wesleyadiel.fittrackerpro.presentation.meal.screen.MealDetailScreen
import com.wesleyadiel.fittrackerpro.presentation.meal.screen.MealScreen
import com.wesleyadiel.fittrackerpro.presentation.workout.screen.WorkoutDetailScreen
import com.wesleyadiel.fittrackerpro.presentation.workout.screen.WorkoutScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.WORKOUT_LIST) {
        composable(Routes.WORKOUT_LIST) {
            WorkoutScreen(onNavigateToDetail = { id ->
                navController.navigate("workout_detail/$id")
            })
        }

        composable(Routes.MEAL_LIST) {
            MealScreen(onNavigateToDetail = { id ->
                navController.navigate("meal_detail/$id")
            })
        }

        composable(Routes.BODY_STATS_LIST) {
            BodyStatsScreen(onNavigateToDetail = { id ->
                navController.navigate("body_stats_detail/$id")
            })
        }

        composable("workout_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            WorkoutDetailScreen(id)
        }

        composable("meal_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            MealDetailScreen(id)
        }

        composable("body_stats_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            BodyStatsDetailScreen(id)
        }
    }
}