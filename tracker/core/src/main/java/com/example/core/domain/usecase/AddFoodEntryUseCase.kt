package com.example.core.domain.usecase

import com.example.core.domain.model.FoodEntry
import com.example.core.domain.repository.FoodRepository

class AddFoodEntryUseCase(private val repository: FoodRepository) {
    suspend operator fun invoke(foodEntry: FoodEntry) {
        repository.addFoodEntry(foodEntry)
    }
}