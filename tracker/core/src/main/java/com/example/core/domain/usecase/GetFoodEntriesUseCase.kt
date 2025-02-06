package com.example.core.domain.usecase

import com.example.core.domain.model.FoodEntry
import com.example.core.domain.repository.FoodRepository

class GetFoodEntriesUseCase(private val repository: FoodRepository) {
    suspend operator fun invoke(): List<FoodEntry> {
        return repository.getFoodEntries()
    }
}