package com.example.core.domain.usecase

import com.example.core.data.remote.dto.MealResponseDTO
import com.example.core.data.remote.dto.NutritionPlanRequestDTO
import com.example.core.data.remote.dto.NutritionPlanResponseDTO
import com.example.core.domain.repository.NutritionRepository
import javax.inject.Inject

class GetMealsUseCase @Inject constructor(
    private val repository: NutritionRepository
) {
    suspend operator fun invoke(plan: Int):List<MealResponseDTO>{
        return repository.getMeals(plan)
    }
}