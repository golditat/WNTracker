package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class RefreshTokenRequestDTO(
    val refresh: String
)