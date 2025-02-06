package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MealDTO(
    val id: Int,
    val name: String,
    val ingredients: List<Int>, // Список ID ингредиентов
    val description: String?,
    val day:String?
)