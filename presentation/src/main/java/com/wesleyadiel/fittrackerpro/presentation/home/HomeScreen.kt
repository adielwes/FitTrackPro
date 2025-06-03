package com.wesleyadiel.fittrackerpro.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.wesleyadiel.fittrackerpro.presentation.home.components.ProgressSummary
import com.wesleyadiel.fittrackerpro.presentation.navigation.Routes.BODY_STATS_LIST
import com.wesleyadiel.fittrackerpro.presentation.navigation.Routes.REGISTER_BODY_STATS_ROUTE

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel
) {
    val systemUiController = rememberSystemUiController()

    val latestStats = viewModel.latestBodyStats.collectAsState()

    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            viewModel.loadLatestStats()
        }
    }

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
        ProgressSummary(
            bodyStats = latestStats,
            onRegisterClick = { navController.navigate(REGISTER_BODY_STATS_ROUTE) },
            onHistoryClick = { navController.navigate(BODY_STATS_LIST) }
        )
    }
}