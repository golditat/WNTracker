package com.example.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_progress")
data class UserProgressEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val weight: Int,
    val height: Int,
    val calories:Int,
    val proteins:Int,
    val fats:Int,
    val carbs:Int
)