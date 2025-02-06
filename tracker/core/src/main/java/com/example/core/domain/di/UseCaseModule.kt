package com.example.core.domain.di

import com.example.core.domain.repository.*
import com.example.core.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetExercisesUseCase(repository: ExerciseRepository): GetExercisesUseCase {
        return GetExercisesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetWorkoutPlansUseCase(repository: WorkoutRepository): GetWorkoutPlansUseCase {
        return GetWorkoutPlansUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddFoodEntryUseCase(repository: FoodRepository): AddFoodEntryUseCase {
        return AddFoodEntryUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideUpdateUserProgressUseCase(repository: UserProgressRepository): UpdateUserProgressUseCase {
        return UpdateUserProgressUseCase(repository)
    }
}