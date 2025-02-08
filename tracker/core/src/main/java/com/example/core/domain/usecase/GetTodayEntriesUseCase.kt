package com.example.core.domain.usecase

import com.example.core.domain.model.FoodEntry
import com.example.core.domain.model.History
import com.example.core.domain.repository.FoodRepository
import com.example.core.domain.repository.HistoryRepository
import javax.inject.Inject

class GetTodayEntriesUseCase @Inject constructor(
    private val repository: FoodRepository
) {
    suspend operator fun invoke(today:String):List<FoodEntry>{
        return repository.getTodayEntries(today)
    }
}