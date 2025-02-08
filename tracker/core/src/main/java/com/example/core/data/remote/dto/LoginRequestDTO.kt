package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDTO(
    val username: String,
    val password: String
)
