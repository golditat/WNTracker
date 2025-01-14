package com.example.core
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.Database
@Database(
    entities = [ExerciseEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters()
abstract class AppDatabase : RoomDatabase(){
    abstract val exerciseDao:ExerciseDao
}