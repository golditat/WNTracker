package com.example.core.domain.repository

import com.example.core.domain.model.UserProgress

interface UserProgressRepository {
    suspend fun getUserProgress(): UserProgress
    suspend fun updateUserProgress(progress: UserProgress)
    suspend fun insertUserProgress(progress:UserProgress)
}