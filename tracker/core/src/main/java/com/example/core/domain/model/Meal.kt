package com.example.core.domain.model

data class Meal (
    val id:Int,
    val plan: Int,
    val meal: Int?,
    val ingredient: String,
    val weightUnit: Int?,
    val datetime: String,
    val amount: String,
    val calories:Int,
    val proteins:Int,
    val fats:Int,
    val carbs:Int
)