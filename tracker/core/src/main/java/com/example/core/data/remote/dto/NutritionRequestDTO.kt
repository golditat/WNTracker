package com.example.core.data.remote.dto

data class NutritionRequestDTO(
    val gender: String,
    val age: Int,
    val height: Int,
    val weight: Int,
    val activityLevel: String,
    val goal: String
)