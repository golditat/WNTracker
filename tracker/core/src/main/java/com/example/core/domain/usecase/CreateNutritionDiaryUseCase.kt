package com.example.core.domain.usecase

import com.example.core.data.remote.dto.NutritionDiaryRequestDTO
import com.example.core.data.remote.dto.NutritionDiaryResponseDTO
import com.example.core.domain.repository.NutritionRepository
import java.lang.RuntimeException
import javax.inject.Inject

class CreateNutritionDiaryUseCase @Inject constructor(
    private val repository: NutritionRepository
) {
    suspend operator fun invoke(plan: Int, meal:Int, ingredient:Int, amount:String, weightUnit:Int, datetime:String ):NutritionDiaryResponseDTO{
        return repository.createNutritionDiary(plan, meal, ingredient, amount, weightUnit, datetime)?: throw RuntimeException()
    }
}