package com.example.core.data.local.repository.impl

import com.example.core.data.local.dao.WorkoutPlanDao
import com.example.core.data.local.entity.WorkoutPlanEntity
import com.example.core.domain.model.Exercise
import com.example.core.domain.model.WorkoutPlan
import com.example.core.domain.repository.ExerciseRepository
import com.example.core.domain.repository.WorkoutRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class WorkoutPlanRepositoryImpl @Inject constructor(
    private val dao: WorkoutPlanDao,
    private val exerciseRepository: ExerciseRepository
) : WorkoutRepository {

    override suspend fun getWorkoutPlans(): List<WorkoutPlan> {
        return dao.getWorkoutPlans().map {entity ->
            WorkoutPlan(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                duration = entity.duration,
                exercises = entity.exerсises
                    .split(",")
                    .mapNotNull { it.toIntOrNull() }
                    .mapNotNull { exerciseId -> exerciseRepository.getExerciseById(exerciseId)
                    }
            )
        }
    }

    override suspend fun getWorkoutPlanById(id: Int): WorkoutPlan? {
        val entity = dao.getWorkoutPlanById(id) ?: return null
        return coroutineScope {
            WorkoutPlan(
                id = entity.id,
                name = entity.name,
                description = entity.description,
                duration = entity.duration,
                exercises = entity.exerсises
                    .split(",")
                    .mapNotNull { it.toIntOrNull() }
                    .mapNotNull { exerciseId ->
                        async { exerciseRepository.getExerciseById(exerciseId) }.await()
                    }
            )
        }
    }

    override suspend fun addExerciseToPlan(planId: Int, exercise: Exercise) {
        val entity = dao.getWorkoutPlanById(planId) ?: return
        val currentExercises = entity.exerсises
            .split(",")
            .mapNotNull { it.toIntOrNull() }
        if (exercise.id in currentExercises) return
        val updatedExercises = (currentExercises + exercise.id).joinToString(",")
        val updatedEntity = entity.copy(exerсises = updatedExercises)

        dao.updateWorkoutPlan(updatedEntity)
    }

    override suspend fun insertWorkoutPlan(plan: WorkoutPlan) {
        dao.insertWorkoutPlans(
            listOf(
                WorkoutPlanEntity(
                    id = plan.id,
                    name = plan.name,
                    description = plan.description,
                    duration = plan.duration,
                    exerсises = plan.exercises.joinToString(",") { it.id.toString() }
                )
            )
        )
    }
}