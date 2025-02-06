package com.example.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.local.entity.FoodEntryEntity

@Dao
interface FoodEntryDao {
    @Query("SELECT * FROM food_entries")
    suspend fun getFoodEntries(): List<FoodEntryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFoodEntry(foodEntry: FoodEntryEntity)

    @Query("SELECT * FROM food_entries WHERE mealTime = :today")
    suspend fun getTodayEntries(today: String): List<FoodEntryEntity>
}