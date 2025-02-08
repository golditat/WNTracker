package com.example.core.domain.usecase

import com.example.core.data.remote.dto.NutritionDiaryResponseDTO
import com.example.core.domain.model.Meal
import com.example.core.domain.repository.NutritionRepository
import javax.inject.Inject

class GetTodayDiariesUseCase @Inject constructor(
    private val repository: NutritionRepository
) {
    suspend operator fun invoke(today:String):List<Meal>{
        return repository.getNutritionDiaries(today)
    }
}