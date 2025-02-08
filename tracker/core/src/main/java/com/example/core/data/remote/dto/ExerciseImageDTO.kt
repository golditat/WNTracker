package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ExerciseImageDTO(
    val id: Int,
    val exercise: Int,  // ID упражнения
    val image: String  // URL изображения
)