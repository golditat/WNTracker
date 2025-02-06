package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class WeightEntryDTO(
    val id: Int,
    val userId: Int,
    val weight: Double,
    val date: String
)