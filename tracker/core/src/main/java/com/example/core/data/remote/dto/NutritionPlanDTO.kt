package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class NutritionPlanDTO(
    val id: Int,
    val name: String,
    val description: String?
)