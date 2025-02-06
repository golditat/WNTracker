package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseDTO(
    val access: String,
    val refresh: String
)