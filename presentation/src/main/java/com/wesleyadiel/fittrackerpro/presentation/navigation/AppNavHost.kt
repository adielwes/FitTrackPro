package com.wesleyadiel.fittrackerpro.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.wesleyadiel.fittrackerpro.presentation.bodystats.screen.BodyStatsDetailScreen
import com.wesleyadiel.fittrackerpro.presentation.bodystats.screen.BodyStatsScreen
import com.wesleyadiel.fittrackerpro.presentation.bodystats.screen.RegisterBodyStatsScreen
import com.wesleyadiel.fittrackerpro.presentation.bodystats.viewmodel.RegisterBodyStatsViewModel
import com.wesleyadiel.fittrackerpro.presentation.home.HomeScreen
import com.wesleyadiel.fittrackerpro.presentation.home.HomeViewModel
import com.wesleyadiel.fittrackerpro.presentation.meal.screen.MealDetailScreen
import com.wesleyadiel.fittrackerpro.presentation.meal.screen.MealScreen
import com.wesleyadiel.fittrackerpro.presentation.workout.screen.WorkoutDetailScreen
import com.wesleyadiel.fittrackerpro.presentation.workout.screen.WorkoutScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    val backClick: () -> Unit = { navController.popBackStack() }

    NavHost(navController = navController, startDestination = Routes.HOME_SCREEN) {
        composable(Routes.HOME_SCREEN) {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(navController, viewModel)
        }

        composable(route = Routes.REGISTER_BODY_STATS_ROUTE) {
            val viewModel: RegisterBodyStatsViewModel = hiltViewModel()
            RegisterBodyStatsScreen(
                uiState = viewModel.uiState.value,
                onEvent = viewModel::onEvent,
                onSave = {
                    viewModel.saveBodyStats()
                    navController.popBackStack()
                },
                onBack = { navController.popBackStack() }
            )
        }

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
            BodyStatsScreen(
                onNavigateToDetail = { id ->
                    navController.navigate("body_stats_detail/$id")
                },
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable("workout_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            WorkoutDetailScreen(id, backClick)
        }

        composable("meal_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            MealDetailScreen(id)
        }

        composable("body_stats_detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull()
            BodyStatsDetailScreen(id = id,  onNavigateBack = { navController.popBackStack() })
        }
    }
}