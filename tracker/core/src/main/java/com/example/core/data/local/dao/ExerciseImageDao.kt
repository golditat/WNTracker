package com.example.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.local.entity.ExerciseImageEntity

@Dao
interface ExerciseImageDao {

    @Query("SELECT * FROM images WHERE id = :id")
    suspend fun getExerciseImageById(id: Int): ExerciseImageEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<ExerciseImageEntity>)
}