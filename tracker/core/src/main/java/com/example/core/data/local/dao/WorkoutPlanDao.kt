package com.example.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.core.data.local.entity.WorkoutPlanEntity


@Dao
interface WorkoutPlanDao {
    @Query("SELECT * FROM workout_plans")
    suspend fun getWorkoutPlans(): List<WorkoutPlanEntity>

    @Query("SELECT * FROM workout_plans WHERE id = :planId")
    suspend fun getWorkoutPlanById(planId: Int): WorkoutPlanEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorkoutPlans(plans: List<WorkoutPlanEntity>)

    @Update
    suspend fun updateWorkoutPlan(plan:WorkoutPlanEntity)
}