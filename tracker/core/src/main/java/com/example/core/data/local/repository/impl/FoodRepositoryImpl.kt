package com.example.core.data.local.repository.impl

import com.example.core.data.local.dao.FoodEntryDao
import com.example.core.data.local.entity.FoodEntryEntity
import com.example.core.domain.model.FoodEntry
import com.example.core.domain.repository.FoodRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val dao: FoodEntryDao
) : FoodRepository {

    override suspend fun getFoodEntries(): List<FoodEntry> {
        return dao.getFoodEntries().map {entity ->
            FoodEntry(
                id = entity.id,
                name = entity.name,
                calories = entity.calories,
                proteins = entity.proteins,
                fats = entity.fats,
                carbs = entity.carbs,
                mealTime = entity.mealTime
            )
        }
    }

    override suspend fun addFoodEntry(entry: FoodEntry) {
        dao.insertFoodEntry(
            FoodEntryEntity(
                name = entry.name,
                calories = entry.calories,
                proteins = entry.proteins,
                fats = entry.fats,
                carbs = entry.carbs,
                mealTime = entry.mealTime
            )
        )
    }

    override suspend fun getTodayEntries(today: String): List<FoodEntry> {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        return dao.getTodayEntries(today).map{entity ->
            FoodEntry(
                id = entity.id,
                name = entity.name,
                calories = entity.calories,
                proteins = entity.proteins,
                fats = entity.fats,
                carbs = entity.carbs,
                mealTime = entity.mealTime
            )
        }
    }
}