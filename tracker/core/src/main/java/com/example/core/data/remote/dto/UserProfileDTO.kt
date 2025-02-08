package com.example.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserProfileDTO(
    val id: Int,
    val user: String,  // Имя пользователя
    val email: String?,
    val age: Int?,
    val height: Float?,
    val weight: Float?
)