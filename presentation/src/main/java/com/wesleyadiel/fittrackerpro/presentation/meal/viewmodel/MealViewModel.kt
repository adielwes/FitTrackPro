package com.wesleyadiel.fittrackerpro.presentation.meal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wesleyadiel.fittrackerpro.domain.meal.usecase.GetAllMeals
import com.wesleyadiel.fittrackerpro.presentation.meal.state.MealUiState
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
class MealViewModel @Inject constructor(
    private val getMealsUseCase: GetAllMeals
) : ViewModel() {

    private val _uiState = MutableStateFlow(MealUiState())
    val uiState: StateFlow<MealUiState> = _uiState.asStateFlow()

    init {
        loadMeals()
    }

    private fun loadMeals() {
        viewModelScope.launch {
            getMealsUseCase()
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .catch { e -> _uiState.update { it.copy(error = e.message, isLoading = false) } }
                .collect { meals ->
                    _uiState.update { it.copy(meals = meals, isLoading = false) }
                }
        }
    }
}