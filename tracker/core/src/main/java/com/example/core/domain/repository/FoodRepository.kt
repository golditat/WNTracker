package com.example.core.domain.repository

import com.example.core.domain.model.FoodEntry

interface FoodRepository {
    suspend fun getFoodEntries(): List<FoodEntry>
    suspend fun addFoodEntry(foodEntry: FoodEntry)
    suspend fun getTodayEntries(today:String):List<FoodEntry>
}