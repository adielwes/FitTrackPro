package com.wesleyadiel.fittrackerpro.presentation.bodystats.viewmodel
import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wesleyadiel.fittrackerpro.domain.bodystats.model.BodyStats
import com.wesleyadiel.fittrackerpro.domain.bodystats.usecase.AddBodyStatsUseCase
import com.wesleyadiel.fittrackerpro.presentation.bodystats.event.RegisterBodyStatsEvent
import com.wesleyadiel.fittrackerpro.presentation.bodystats.state.RegisterBodyStatsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class RegisterBodyStatsViewModel @Inject constructor(
    private val addBodyStatsUseCase: AddBodyStatsUseCase
) : ViewModel() {

    var uiState = mutableStateOf(
        RegisterBodyStatsUiState(
            date = LocalDate.now().toEpochDay()
        )
    )
        private set

    fun onEvent(event: RegisterBodyStatsEvent) {
        when (event) {
            is RegisterBodyStatsEvent.OnWeightChanged -> {
                uiState.value = uiState.value.copy(weight = event.value)
            }
            is RegisterBodyStatsEvent.OnBodyFatChanged -> {
                uiState.value = uiState.value.copy(bodyFatPercentage = event.value)
            }
            is RegisterBodyStatsEvent.OnVisceralFatChanged -> {
                uiState.value = uiState.value.copy(visceralFat = event.value)
            }
            is RegisterBodyStatsEvent.OnSkeletalMuscleChanged -> {
                uiState.value = uiState.value.copy(skeletalMuscle = event.value)
            }
            is RegisterBodyStatsEvent.OnPhotoSelected -> {
                uiState.value = uiState.value.copy(photoUri = event.uri)
            }

            is RegisterBodyStatsEvent.OnRemovePhotoClicked -> {
                uiState.value = uiState.value.copy(photoUri = null)
            }
            is RegisterBodyStatsEvent.OnDateChanged -> {
                uiState.value = uiState.value.copy(date = event.value)
            }
        }
    }

    fun updatePhoto(uri: Uri) {
        uiState.value = uiState.value.copy(photoUri = uri)
    }

    fun updateDate(newDate: Long) {
        uiState.value = uiState.value.copy(date = newDate)
    }

    fun saveBodyStats() {
        val weight = uiState.value.weight.toDoubleOrNull()

        if (weight == null) {
            // Create an UI event to show error message (Snackbar, Toast)
            return
        }

        val bodyStats = BodyStats(
            id = 0,
            date = uiState.value.date,
            weight = weight,
            bodyFat = uiState.value.bodyFatPercentage.toDoubleOrNull() ?: 0.0,
            visceralFat = uiState.value.visceralFat.toDoubleOrNull() ?: 0.0,
            skeletalMuscle = uiState.value.skeletalMuscle.toDoubleOrNull() ?: 0.0,
            imageUri = null
        )

        viewModelScope.launch {
            addBodyStatsUseCase(bodyStats, uiState.value.photoUri)
        }
    }
}