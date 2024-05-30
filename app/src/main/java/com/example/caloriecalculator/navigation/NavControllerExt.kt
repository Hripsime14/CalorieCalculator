package com.example.caloriecalculator.navigation

import androidx.navigation.NavHostController
import com.example.core.util.UiEvent


fun NavHostController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}