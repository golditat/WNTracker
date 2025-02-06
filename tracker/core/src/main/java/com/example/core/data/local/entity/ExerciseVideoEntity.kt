package com.example.core.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "videos", foreignKeys = [ForeignKey(ExerciseEntity::class, parentColumns = ["id"], childColumns = ["exercise"])])
data class ExerciseVideoEntity(
    @PrimaryKey val id: Int,
    val exercise: Int,
    val image: String
)