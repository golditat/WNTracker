package com.example.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientDTO(
    val id: Int,
    val name: String,
    val energy: Int,
    val protein: Double,
    val carbohydrates: Double,
    @SerialName("fat") val fats: Double
)
