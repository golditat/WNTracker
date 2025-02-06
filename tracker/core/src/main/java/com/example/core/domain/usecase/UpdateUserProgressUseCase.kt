package com.example.core.domain.usecase

import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.UserProgressRepository

class UpdateUserProgressUseCase(private val repository: UserProgressRepository) {
    suspend operator fun invoke(progress: UserProgress) {
        repository.updateUserProgress(progress)
    }
}