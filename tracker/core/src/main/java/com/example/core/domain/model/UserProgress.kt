package com.example.core.domain.model

import java.util.Date

data class UserProgress(
    val id: Int,
    val weight: Int,
    val height: Int,
    val calories: Int,
    val proteins: Int,
    val fats: Int,
    val carbs:Int
)