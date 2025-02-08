package com.example.core.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "images", foreignKeys = [ForeignKey(ExerciseEntity::class, parentColumns = ["id"], childColumns = ["exercise"])])
data class ExerciseImageEntity(
    @PrimaryKey val id: Int,
    val exercise: Int,
    val image: String
)