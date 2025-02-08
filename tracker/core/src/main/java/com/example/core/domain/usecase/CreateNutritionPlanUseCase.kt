package com.example.core.domain.usecase

import com.example.core.data.remote.dto.NutritionPlanRequestDTO
import com.example.core.data.remote.dto.NutritionPlanResponseDTO
import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.NutritionRepository
import javax.inject.Inject

class CreateNutritionPlanUseCase @Inject constructor(
    private val repository: NutritionRepository
) {
    suspend operator fun invoke(plan: NutritionPlanRequestDTO):Result<NutritionPlanResponseDTO>{
        return repository.createNutritionPlan(plan)
    }
}