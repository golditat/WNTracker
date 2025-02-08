package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NutritionPlanResponseDTO (
    val id: Int,
    val creation_date: String,
    val description: String,
    val only_logging: Boolean,
    val goal_energy: Int,
    val goal_protein: Int,
    val goal_carbohydrates: Int,
    val goal_fat: Int,
    val goal_fiber: Int = 0
)