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
    @Provides
    @Singleton
    fun provideGetUserProgressUseCase(repository: UserProgressRepository): GetUserProgressUseCase {
        return GetUserProgressUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideAddUserProgressUseCase(repository: UserProgressRepository): AddUserProgressUseCase {
        return AddUserProgressUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideCreateMealUseCase(repository: NutritionRepository): CreateMealUseCase {
        return CreateMealUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideCreateNutritionDiaryUseCase(repository: NutritionRepository): CreateNutritionDiaryUseCase {
        return CreateNutritionDiaryUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideCreateNutritionPlanUseCase(repository: NutritionRepository): CreateNutritionPlanUseCase {
        return CreateNutritionPlanUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetFoodEntriesUseCase(repository: FoodRepository): GetFoodEntriesUseCase {
        return GetFoodEntriesUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetHistoryUseCase(repository: HistoryRepository): GetHistoryUseCase {
        return GetHistoryUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideMealsUseCase(repository: NutritionRepository): GetMealsUseCase {
        return GetMealsUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetTodayDiariesUseCase(repository: NutritionRepository): GetTodayDiariesUseCase {
        return GetTodayDiariesUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetTodayEntriesUseCase(repository: FoodRepository): GetTodayEntriesUseCase {
        return GetTodayEntriesUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AuthRepository): LoginUsecase {
        return LoginUsecase(repository)
    }
    @Provides
    @Singleton
    fun provideSaveHistoryUseCase(repository: HistoryRepository): SaveHistoryUseCase {
        return SaveHistoryUseCase(repository)
    }
}