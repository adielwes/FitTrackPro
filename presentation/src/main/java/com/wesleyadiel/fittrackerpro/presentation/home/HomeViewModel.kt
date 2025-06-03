package com.wesleyadiel.fittrackerpro.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.usecase.GetLatestBodyStatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getLatestBodyStats: GetLatestBodyStatsUseCase
) : ViewModel() {

    private val _latestBodyStats = MutableStateFlow<BodyStats?>(null)
    val latestBodyStats: StateFlow<BodyStats?> = _latestBodyStats

    init {
        loadLatestStats()
    }

    fun loadLatestStats() {
        viewModelScope.launch {
            getLatestBodyStats()?.let { latest ->
                _latestBodyStats.value = latest
            }
        }
    }
}