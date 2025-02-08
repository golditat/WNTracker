package com.example.core.domain.usecase

import com.example.core.domain.model.WorkoutPlan
import com.example.core.domain.repository.WorkoutRepository

class GetWorkoutPlansUseCase(private val repository: WorkoutRepository) {
    suspend operator fun invoke(): List<WorkoutPlan> {
        return repository.getWorkoutPlans()
    }
}