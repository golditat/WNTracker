package com.example.core

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises")
data class ExerciseEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "description")val description: String,
    @ColumnInfo(name = "category")val category: Int,
    @ColumnInfo(name = "equipment")val equipment: String
)