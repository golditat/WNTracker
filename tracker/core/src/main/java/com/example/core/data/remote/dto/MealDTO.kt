package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MealRequestDTO(
    val time: String,
    val name: String,
    val plan:Int
)

@Serializable
data class MealResponseDTO(
    val id:Int,
    val time: String,
    val name: String,
    val plan:Int,
    val order:Int,
)