package com.example.core.data.local

import android.content.Context
import androidx.room.Room
import com.example.core.data.local.entity.ExerciseEntity

suspend fun testDatabase(context: Context) {
    val db = Room.inMemoryDatabaseBuilder(
        context, AppDatabase::class.java
    ).build()

    val exerciseDao = db.exerciseDao()

    val testExercise = ExerciseEntity(1, "Push-up", "Basic push-up", "Strength", "Chest, Arms", "Bodyweight")
    exerciseDao.insertExercises(listOf(testExercise))

    val exercises = exerciseDao.getAllExercises()
    println("Exercises in DB: $exercises")
}