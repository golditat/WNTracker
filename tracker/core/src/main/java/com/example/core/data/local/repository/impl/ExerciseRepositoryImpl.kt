package com.example.core.data.local.repository.impl

import com.example.core.data.local.dao.ExerciseDao
import com.example.core.data.local.entity.ExerciseEntity
import com.example.core.data.local.utils.Categories
import com.example.core.data.local.utils.Equipment
import com.example.core.data.local.utils.Muscle
import com.example.core.data.remote.api.WgerApiService
import com.example.core.domain.model.Exercise
import com.example.core.domain.repository.ExerciseRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val api: WgerApiService,
    private val dao: ExerciseDao
) : ExerciseRepository {

    override suspend fun getExercises(): List<Exercise> {
        return dao.getAllExercises().map { entity ->
                Exercise(
                    id = entity.id,
                    name = entity.name,
                    description = entity.description,
                    category = Categories.fromName(entity.category),
                    muscles = entity.muscles.split(",").map { Muscle.fromName(it) },
                    equipment = entity.equipment.split(",").map{Equipment.fromName(it)}
                )
            }
        }

    override suspend fun getExerciseById(id: Int): Exercise? {
        val entity = dao.getExerciseById(id) ?: return null
        return coroutineScope {
            Exercise(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                category = Categories.fromName(entity.category),
                muscles = entity.muscles.split(",").mapNotNull { Muscle.fromName(it)},
                equipment = entity.equipment.split(",").mapNotNull { Equipment.fromName(it)}
            )
        }
    }

    override suspend fun fetchExercisesFromApi(id:Int) {
        val response = api.getExerciseById(id)
        val entities = response.run {  ->
            ExerciseEntity(
                id = this.id,
                name = this.name,
                description = this.description ?: "",
                category = Categories.fromId(this.categoryId).name,
                muscles = this.muscles.joinToString(","),
                equipment = this.equipment.joinToString(",")
            )
        }
        dao.insertExercises(listOf( entities))
    }
}