package com.example.core.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExerciseDTO(
    val id: Int,
    val name: String,
    val description: String,
    @SerialName("category") val categoryId: Int,
    val muscles: List<Int>,
    @SerialName("muscles_secondary") val secondaryMuscles: List<Int>,
    val equipment: List<Int>,
    val language: Int,
    @SerialName("license") val licenseId: Int,
    @SerialName("license_author") val licenseAuthor: String,
    @SerialName("creation_date") val creationDate: String,
    @SerialName("uuid") val uuid: String
)
