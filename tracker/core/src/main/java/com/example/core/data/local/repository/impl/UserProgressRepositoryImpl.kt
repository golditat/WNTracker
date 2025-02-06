package com.example.core.data.local.repository.impl

import com.example.core.data.local.dao.UserProgressDao
import com.example.core.data.local.entity.UserProgressEntity
import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.UserProgressRepository
import java.sql.Date
import javax.inject.Inject

class UserProgressRepositoryImpl @Inject constructor(
    private val dao: UserProgressDao
) : UserProgressRepository {

    override suspend fun getUserProgress(): UserProgress {
        return dao.getUserProgress().run {
            UserProgress(
                id = this.id,
                weight = this.weight,
                height = this.height,
                calories = this.calories,
                proteins = this.proteins,
                fats = this.fats,
                carbs = this.carbs
            )
        }
    }

    override suspend fun insertUserProgress(progress: UserProgress) {
        dao.insertUserProgress(
            UserProgressEntity(
                weight = progress.weight,
                height = progress.height,
                calories = progress.calories,
                proteins = progress.proteins,
                fats = progress.fats,
                carbs = progress.carbs
            )
        )
    }

    override suspend fun updateUserProgress(progress: UserProgress) {
        dao.updateUserProgress(
            UserProgressEntity(
                id = progress.id,
                weight = progress.weight,
                height = progress.height,
                calories = progress.calories,
                proteins = progress.proteins,
                fats = progress.fats,
                carbs = progress.carbs
            )
        )
    }
}