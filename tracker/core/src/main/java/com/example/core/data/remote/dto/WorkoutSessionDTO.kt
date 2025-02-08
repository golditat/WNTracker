package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WorkoutSessionDTO(
    val id: Int,
    val workout: Int,
    val duration: Int
)