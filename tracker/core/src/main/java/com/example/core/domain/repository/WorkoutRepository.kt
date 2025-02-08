package com.example.core.domain.repository

import com.example.core.domain.model.Exercise
import com.example.core.domain.model.WorkoutPlan

interface WorkoutRepository {
    suspend fun getWorkoutPlans(): List<WorkoutPlan>
    suspend fun getWorkoutPlanById(id: Int): WorkoutPlan?
    suspend fun addExerciseToPlan(planId: Int, exercise: Exercise)
    suspend fun insertWorkoutPlan(plan:WorkoutPlan)
}