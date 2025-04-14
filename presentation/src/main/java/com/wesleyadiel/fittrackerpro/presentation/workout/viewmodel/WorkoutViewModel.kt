package com.wesleyadiel.fittrackerpro.presentation.workout.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wesleyadiel.fittrackerpro.domain.workout.model.Workout
import com.wesleyadiel.fittrackerpro.domain.workout.usecase.GetAllWorkouts
import com.wesleyadiel.fittrackerpro.presentation.workout.state.WorkoutUiState
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
class WorkoutViewModel @Inject constructor(
    private val getWorkouts: GetAllWorkouts
) : ViewModel() {

    private val _uiState = MutableStateFlow(WorkoutUiState())
    val uiState: StateFlow<WorkoutUiState> = _uiState.asStateFlow()

    init {
        loadWorkouts()
    }

    private fun loadWorkouts() {
        viewModelScope.launch {
            getWorkouts()
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .catch { e -> _uiState.update { it.copy(error = e.message, isLoading = false) } }
                .collect { workouts: List<Workout> ->
                    _uiState.update { it.copy(workouts = workouts, isLoading = false) }
                }
        }
    }
}