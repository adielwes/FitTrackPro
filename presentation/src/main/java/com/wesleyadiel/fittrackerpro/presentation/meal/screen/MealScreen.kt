package com.wesleyadiel.fittrackerpro.presentation.meal.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.wesleyadiel.fittrackerpro.presentation.meal.component.MealItem
import com.wesleyadiel.fittrackerpro.presentation.meal.viewmodel.MealViewModel

@Composable
fun MealScreen(onNavigateToDetail: (Long) -> Unit) {
    val viewModel: MealViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    LazyColumn {
        items(state.value.meals) { meal ->
            MealItem(
                meal = meal,
                modifier = Modifier.clickable { onNavigateToDetail(meal.id) }
            )
        }
    }
}