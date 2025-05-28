package com.wesleyadiel.fittrackerpro.presentation.bodystats.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.wesleyadiel.fittrackerpro.presentation.bodystats.component.BodyStatsItem
import com.wesleyadiel.fittrackerpro.presentation.bodystats.viewmodel.BodyStatsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BodyStatsScreen(
    onNavigateToDetail: (Long) -> Unit,
    onNavigateBack: () -> Unit
) {
    val viewModel: BodyStatsViewModel = hiltViewModel()
    val state = viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Body Stats") },
                navigationIcon = {
                    IconButton(onClick = { onNavigateBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            items(state.value.bodyStats) { bodyStats ->
                BodyStatsItem(
                    bodyStats = bodyStats,
                    modifier = Modifier.clickable { onNavigateToDetail(bodyStats.id) }
                )
            }
        }
    }
}