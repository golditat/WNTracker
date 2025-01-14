package com.example.core
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.Database
@Database(
    entities = [ExerciseEntity::class],
    version = 1
)
@TypeConverters( )
abstract class AppDatabase : RoomDatabase(){
    abstract fun exerciseDao():ExerciseDao
}