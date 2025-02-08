package com.example.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.local.entity.ExerciseImageEntity
import com.example.core.data.local.entity.ExerciseVideoEntity

@Dao
interface ExerciseVideoDao {

    @Query("SELECT * FROM images WHERE id = :id")
    suspend fun getExerciseVideoById(id: Int): ExerciseVideoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVideos(images: List<ExerciseVideoEntity>)
}