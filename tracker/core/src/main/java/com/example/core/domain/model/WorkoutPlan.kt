package com.example.core.domain.model

data class WorkoutPlan (
    val id: Int,
    val name: String,
    val description: String,
    val exercises: List<Exercise>,
    val duration: Int
)