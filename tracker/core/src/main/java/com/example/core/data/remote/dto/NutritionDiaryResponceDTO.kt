package com.example.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NutritionDiaryResponseDTO(
    val id:Int,
    val plan: Int,
    val meal: Int?,
    val ingredient: Int,
    val weightUnit: Int?,
    val datetime: String,
    val amount: String
)