package com.wesleyadiel.fittrackerpro.presentation.bodystats.event

import android.net.Uri

sealed class RegisterBodyStatsEvent {
    data class OnWeightChanged(val value: String) : RegisterBodyStatsEvent()
    data class OnBodyFatChanged(val value: String) : RegisterBodyStatsEvent()
    data class OnVisceralFatChanged(val value: String) : RegisterBodyStatsEvent()
    data class OnSkeletalMuscleChanged(val value: String) : RegisterBodyStatsEvent()
    data class OnPhotoSelected(val uri: Uri) : RegisterBodyStatsEvent()
    object OnRemovePhotoClicked : RegisterBodyStatsEvent()
    data class OnDateChanged(val value: Long) : RegisterBodyStatsEvent()
}