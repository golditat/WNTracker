package com.example.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkoutLogDTO(
    val id: Int,
    @SerialName("exercise") val exerciseId: Int,
    val reps: Int?,
    val weight: Float?,
    val date: String
)