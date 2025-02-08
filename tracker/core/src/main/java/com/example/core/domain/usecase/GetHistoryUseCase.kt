package com.example.core.domain.usecase

import com.example.core.domain.model.History
import com.example.core.domain.repository.HistoryRepository
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val repository: HistoryRepository
) {
    suspend operator fun invoke():List<History>{
        return repository.getHistory()
    }
}