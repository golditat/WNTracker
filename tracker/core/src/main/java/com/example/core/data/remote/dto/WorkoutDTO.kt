package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WorkoutDTO(
    val id: Int,
    val creationDate: String,
    val description: String,
    val exercises: List<Int>
)