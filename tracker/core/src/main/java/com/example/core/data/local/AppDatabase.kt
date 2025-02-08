package com.example.core.data.local

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.Room
import com.example.core.data.local.dao.ExerciseDao
import com.example.core.data.local.dao.FoodEntryDao
import com.example.core.data.local.dao.HistoryDao
import com.example.core.data.local.dao.UserProgressDao
import com.example.core.data.local.dao.WorkoutPlanDao
import com.example.core.data.local.entity.ExerciseEntity
import com.example.core.data.local.entity.FoodEntryEntity
import com.example.core.data.local.entity.HistoryEntity
import com.example.core.data.local.entity.UserProgressEntity
import com.example.core.data.local.entity.WorkoutPlanEntity

@Database(
    entities = [UserProgressEntity::class, WorkoutPlanEntity::class, ExerciseEntity::class, FoodEntryEntity::class, HistoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userProgressDao(): UserProgressDao
    abstract fun workoutPlanDao(): WorkoutPlanDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun foodEntryDao():FoodEntryDao
    abstract fun historyDao():HistoryDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "tracker_db"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}