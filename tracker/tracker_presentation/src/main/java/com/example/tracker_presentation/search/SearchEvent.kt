package com.example.tracker_presentation.search

import com.example.tracker_domain.model.MealType
import com.example.tracker_domain.model.TrackableFood
import com.example.tracker_domain.model.TrackedFood
import java.time.LocalDate

sealed class SearchEvent {
    data class OnQueryChange(val query: String): SearchEvent()
    data object OnSearch: SearchEvent()
    data class OnToggleTrackableFood(val food: TrackableFood): SearchEvent()
    data class OnAmountOnFoodChange(val food: TrackableFood, val amount: String): SearchEvent()
    data class OnTrackFoodClick(val food: TrackableFood, val mealType: MealType, val date: LocalDate): SearchEvent()
    data class OnSearchFocusChange(val isFocused: Boolean): SearchEvent()
}