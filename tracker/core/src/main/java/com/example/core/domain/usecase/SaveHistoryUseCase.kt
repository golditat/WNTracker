package com.example.core.domain.usecase

import com.example.core.domain.model.History
import com.example.core.domain.repository.HistoryRepository
import javax.inject.Inject

class SaveHistoryUseCase @Inject constructor(
    private val repository: HistoryRepository
) {
    suspend operator fun invoke(history: History){
        return repository.saveHistory(history)
    }
}