package com.example.core.domain.usecase

import com.example.core.domain.model.Exercise
import com.example.core.domain.repository.ExerciseRepository

class GetExercisesUseCase(private val repository: ExerciseRepository) {
    suspend operator fun invoke(): List<Exercise> {
        return repository.getExercises()
    }
}