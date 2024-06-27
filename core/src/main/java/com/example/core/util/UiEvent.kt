package com.example.core.util

sealed class UiEvent {
    object  Success: UiEvent()
    data object NavigateUp: UiEvent()
    data class ShowSnackbar(val uiText: UiText): UiEvent()
}