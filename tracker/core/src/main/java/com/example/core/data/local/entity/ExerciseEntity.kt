package com.example.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val category: String,
    val muscles: String, // Сохраняем список через запятую
    val equipment: String
)