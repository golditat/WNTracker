package com.example.core

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

class ExerciseDao {
    @Dao
    interface ExerciseDao {
        @Query("SELECT * FROM exercises")
        fun getAllExercises(): Flow<List<ExerciseEntity>>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertExercises(exercises: List<ExerciseEntity>)
    }

}