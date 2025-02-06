package com.example.core.domain.repository

import com.example.core.domain.model.History

interface HistoryRepository {
    suspend fun saveHistory(history: History)
    suspend fun getHistory():List<History>
}