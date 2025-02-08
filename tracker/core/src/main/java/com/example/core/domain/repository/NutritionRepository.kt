package com.example.core.domain.repository

import com.example.core.data.remote.api.WgerApiService
import com.example.core.data.remote.dto.MealResponseDTO
import com.example.core.data.remote.dto.NutritionDiaryResponseDTO
import com.example.core.data.remote.dto.NutritionPlanRequestDTO
import com.example.core.data.remote.dto.NutritionPlanResponseDTO
import com.example.core.domain.model.Meal
import javax.inject.Inject

interface NutritionRepository{
    suspend fun createNutritionPlan(plan: NutritionPlanRequestDTO): Result<NutritionPlanResponseDTO>
    suspend fun createNutritionDiary(planId: Int, mealId: Int?, ingredientId: Int, amount: String, weightUnit: Int?, time:String): NutritionDiaryResponseDTO?
    suspend fun getMeals(planId: Int): List<MealResponseDTO>
    suspend fun createMeal(planId: Int, mealName: String, time:String): MealResponseDTO?
    suspend fun getNutritionDiaries(date:String):List<Meal>
}