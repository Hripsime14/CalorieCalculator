package com.example.tracker_data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tracker_data.local.LocalDbConstants

@Entity(tableName = LocalDbConstants.CALORIE_TABLE_NAME)
data class TrackedFoodEntity(
    val name: String,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
    val imageUrl: String?,
    val type: String,
    val amount: Int,
    val dayOfMonth: Int,
    val month: Int,
    val year: Int,
    val calories: Int,
    @PrimaryKey val id: Int? = null
)