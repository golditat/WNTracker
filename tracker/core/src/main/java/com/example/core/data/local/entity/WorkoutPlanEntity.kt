package com.example.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_plans")
data class WorkoutPlanEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val duration: Int,
    val exerсises:String
)