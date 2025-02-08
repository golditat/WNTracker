package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class EquipmentDTO(
    val id: Int,
    val name: String
)