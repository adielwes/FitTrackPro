package com.wesleyadiel.fittrackerpro.presentation.bodystats.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wesleyadiel.fittrackerpro.domain.bodystats.usecase.GetAllBodyStats
import com.wesleyadiel.fittrackerpro.presentation.bodystats.state.BodyStatsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BodyStatsViewModel @Inject constructor(
    private val getBodyStats: GetAllBodyStats
) : ViewModel() {

    private val _uiState = MutableStateFlow(BodyStatsUiState())
    val uiState: StateFlow<BodyStatsUiState> = _uiState.asStateFlow()

    init {
        loadProgress()
    }

    private fun loadProgress() {
        viewModelScope.launch {
            getBodyStats()
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .catch { e -> _uiState.update { it.copy(error = e.message, isLoading = false) } }
                .collect { list ->
                    _uiState.update { it.copy(bodyStats = list, isLoading = false) }
                }
        }
    }
}