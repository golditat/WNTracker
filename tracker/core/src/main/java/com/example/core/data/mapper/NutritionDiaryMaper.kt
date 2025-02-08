package com.example.core.data.mapper

import com.example.core.data.remote.dto.IngredientDTO
import com.example.core.data.remote.dto.NutritionDiaryResponseDTO
import com.example.core.domain.model.Meal

fun NutritionDiaryResponseDTO.toDomain(ingredient:IngredientDTO): Meal {
    return Meal(
        id, plan, meal, ingredient.name, weightUnit, datetime, amount, calories = ingredient.energy, proteins = ingredient.protein.toInt(), carbs = ingredient.carbohydrates.toInt(), fats = ingredient.fats.toInt()
    )
}