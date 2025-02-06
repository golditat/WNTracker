package com.example.core.domain.usecase

import com.example.core.domain.model.Exercise
import com.example.core.domain.repository.WorkoutRepository

class AddExerciseToPlanUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(planId: Int, exercise: Exercise) {
        repository.addExerciseToPlan(planId, exercise)
    }
}