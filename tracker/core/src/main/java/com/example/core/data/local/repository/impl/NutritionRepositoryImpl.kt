package com.example.core.data.local.repository.impl

import com.example.core.data.local.dao.FoodEntryDao
import com.example.core.data.local.entity.FoodEntryEntity
import com.example.core.data.mapper.toDomain
import com.example.core.data.remote.api.WgerApiService
import com.example.core.data.remote.dto.MealRequestDTO
import com.example.core.data.remote.dto.MealResponseDTO
import com.example.core.data.remote.dto.NutritionDiaryRequestDTO
import com.example.core.data.remote.dto.NutritionDiaryResponseDTO
import com.example.core.data.remote.dto.NutritionPlanRequestDTO
import com.example.core.data.remote.dto.NutritionPlanResponseDTO
import com.example.core.domain.model.Meal
import com.example.core.domain.repository.NutritionRepository
import java.time.Instant
import javax.inject.Inject

class NutritionRepositoryImpl @Inject constructor(
    private val api: WgerApiService,
    private val dao: FoodEntryDao
) :NutritionRepository{
    override suspend fun createNutritionPlan(plan: NutritionPlanRequestDTO): Result<NutritionPlanResponseDTO> {
        return try {
            val response = api.createNutritionPlan(plan)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Ошибка: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun createNutritionDiary(planId: Int, mealId: Int?, ingredientId: Int, amount: String, weightUnit: Int?, time:String): NutritionDiaryResponseDTO? {
        val newDiaryEntry = NutritionDiaryRequestDTO(
            plan = planId,
            meal = mealId,
            ingredient = ingredientId,
            weightUnit = weightUnit,
            datetime = time,
            amount = amount
        )
        val response = api.createNutritionDiary(newDiaryEntry)
        return response.body()
    }

    override suspend fun getMeals(planId: Int): List<MealResponseDTO> {
        val response = api.getMeals(planId)
        return response.body()?.results ?: emptyList()
    }

    override suspend fun createMeal(planId: Int, mealName: String, time:String): MealResponseDTO? {
        val newMeal = MealRequestDTO(
            name = mealName,
            time = time,
            plan = planId
        )
        val response = api.createMeal(newMeal)
        return response.body()
    }

    override suspend fun getNutritionDiaries(date: String): List<Meal> {
        return api.getNutritionDiary(date).body()?.results?.map {
            val ingredient = api.getIngredient(it.ingredient)
            it.toDomain(ingredient)
        } ?: emptyList()
    }
}
