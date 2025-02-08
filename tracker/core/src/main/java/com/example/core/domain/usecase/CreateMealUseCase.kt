package com.example.core.domain.usecase

import com.example.core.data.remote.dto.MealRequestDTO
import com.example.core.data.remote.dto.MealResponseDTO
import com.example.core.data.remote.dto.NutritionPlanRequestDTO
import com.example.core.data.remote.dto.NutritionPlanResponseDTO
import com.example.core.domain.repository.NutritionRepository
import javax.inject.Inject

class CreateMealUseCase @Inject constructor(
    private val repository: NutritionRepository
) {
    suspend operator fun invoke(plan: MealRequestDTO):MealResponseDTO{
        return repository.createMeal(plan.plan, plan.name, plan.time)?:MealResponseDTO(0,"0","0", 0, 0)
    }
}