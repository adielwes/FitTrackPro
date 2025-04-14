package com.wesleyadiel.fittrackerpro.presentation.bodystats.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.wesleyadiel.fittrackerpro.presentation.bodystats.component.BodyStatsItem
import com.wesleyadiel.fittrackerpro.presentation.bodystats.viewmodel.BodyStatsViewModel

@Composable
fun BodyStatsScreen(onNavigateToDetail: (Long) -> Unit) {
    val viewModel: BodyStatsViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    LazyColumn {
        items(state.value.bodyStats) { bodyStats ->
            BodyStatsItem(
                bodyStats = bodyStats,
                modifier = Modifier.clickable { onNavigateToDetail(bodyStats.id) }
            )
        }
    }
}