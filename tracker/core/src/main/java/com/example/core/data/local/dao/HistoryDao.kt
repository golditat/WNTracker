package com.example.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.local.entity.FoodEntryEntity
import com.example.core.data.local.entity.HistoryEntity


@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    suspend fun getHistory(): List<HistoryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHistory(history: HistoryEntity)
}