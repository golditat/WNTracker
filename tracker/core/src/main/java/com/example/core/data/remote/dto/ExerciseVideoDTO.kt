package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ExerciseVideoDTO(
    val id: Int,
    val exercise: Int,  // ID упражнения
    val video: String  // URL видео
)