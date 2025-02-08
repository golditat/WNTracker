package com.example.core.domain.model

data class FoodEntry (
    val id: Int,
    val name: String,
    val calories: Int,
    val proteins: Float,
    val fats: Float,
    val carbs: Float,
    val mealTime: String
)