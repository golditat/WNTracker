package com.example.core.domain.usecase

import com.example.core.domain.model.FoodEntry
import com.example.core.domain.repository.FoodRepository
import javax.inject.Inject

class GetFoodEntriesUseCase @Inject constructor(
    private val repository: FoodRepository
) {
    suspend operator fun invoke(): List<FoodEntry> {
        return repository.getFoodEntries()
    }
}