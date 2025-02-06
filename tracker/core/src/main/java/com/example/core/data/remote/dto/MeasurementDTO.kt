package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MeasurementDTO(
    val id: Int,
    val userId: Int,
    val category: Int,
    val value: Double,
    val date: String
)