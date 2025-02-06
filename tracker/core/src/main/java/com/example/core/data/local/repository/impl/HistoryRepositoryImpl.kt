package com.example.core.data.local.repository.impl

import com.example.core.data.local.dao.FoodEntryDao
import com.example.core.data.local.dao.HistoryDao
import com.example.core.data.local.entity.FoodEntryEntity
import com.example.core.data.local.entity.HistoryEntity
import com.example.core.domain.model.FoodEntry
import com.example.core.domain.model.History
import com.example.core.domain.repository.FoodRepository
import com.example.core.domain.repository.HistoryRepository
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val dao: HistoryDao
) : HistoryRepository {

    override suspend fun getHistory(): List<History> {
        return dao.getHistory().map {entity ->
            History(
                id = entity.id,
                weight = entity.weight,
                date = entity.date
            )
        }
    }

    override suspend fun saveHistory(history: History) {
        dao.saveHistory(
            HistoryEntity(
                weight = history.weight,
                date = history.date
            )
        )
    }
}