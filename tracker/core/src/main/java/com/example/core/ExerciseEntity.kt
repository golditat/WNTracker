package com.example.core

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
class ExerciseEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val category: Int,
    val equipment: List<Int>
)