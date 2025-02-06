package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class IngredientDTO(
    val id: Int,
    val name: String,
    val energy: Float, // Энергетическая ценность (ккал)
    val protein: Float, // Белки (г)
    val carbohydrates: Float, // Углеводы (г)
    val fat: Float, // Жиры (г)
    val amount: Float?, // Количество
    val unit: String? // Единица измерения (г, мл и т. д.)
)

@Serializable
data class IngredientWeightUnitDto(
    val id: Int,
    val name: String
)