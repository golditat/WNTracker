package com.example.core.domain.repository

import com.example.core.domain.model.Exercise

interface ExerciseRepository {
    suspend fun getExercises(): List<Exercise>
    suspend fun getExerciseById(id: Int): Exercise?
    suspend fun fetchExercisesFromApi(id:Int)
}