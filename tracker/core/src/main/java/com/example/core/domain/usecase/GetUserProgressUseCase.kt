package com.example.core.domain.usecase

import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.UserProgressRepository
import javax.inject.Inject

class GetUserProgressUseCase @Inject constructor(
    private val repository:UserProgressRepository
) {
    suspend operator fun invoke():UserProgress{
        return repository.getUserProgress()
    }
}