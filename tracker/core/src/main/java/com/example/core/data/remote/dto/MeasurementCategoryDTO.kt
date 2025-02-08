package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MeasurementCategoryDTO(
    val id: Int,
    val name: String
)