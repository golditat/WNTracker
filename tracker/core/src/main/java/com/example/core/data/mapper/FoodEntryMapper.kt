package com.example.core.data.mapper

import com.example.core.data.local.entity.FoodEntryEntity
import com.example.core.data.remote.dto.IngredientDTO
import com.example.core.domain.model.FoodEntry
import com.example.core.domain.repository.WgerRepository

fun FoodEntryEntity.toDomain():FoodEntry{
    return FoodEntry(
        id = this.id,
        name = name,
        calories = calories,
        proteins = proteins,
        fats = fats,
        carbs = carbs,
        mealTime = mealTime
    )
}

/*
suspend fun MealDTO.toFoodEntryEntity(repository: WgerRepository): FoodEntryEntity {
    val mealItems: List<IngredientDTO> = this.ingredients.map { repository.getIngredients(it) }

    val totalCalories = mealItems.sumOf { it.energy.toInt() }
    val totalProteins = mealItems.sumOf { it.protein.toDouble()  }
    val totalFats = mealItems.sumOf { it.fat.toDouble() }
    val totalCarbs = mealItems.sumOf { it.carbohydrates.toDouble() }

    return FoodEntryEntity(
        id = this.id,
        name = this.name,
        calories = totalCalories,
        proteins = totalProteins.toFloat(),
        fats = totalFats.toFloat(),
        carbs = totalCarbs.toFloat(),
        mealTime = this.day ?: "ERROR"
    )
}*/
