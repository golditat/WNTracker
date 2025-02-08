package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NutritionPlanRequestDTO(
    val description: String,
    val only_logging: Boolean = true,
    val goal_energy: Int,
    val goal_protein: Int,
    val goal_carbohydrates: Int,
    val goal_fat: Int,
    val goal_fiber: Int = 0
)