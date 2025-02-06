package com.example.core.domain.repository

import com.example.core.data.local.dao.ExerciseDao
import com.example.core.data.local.dao.ExerciseImageDao
import com.example.core.data.local.dao.ExerciseVideoDao
import com.example.core.data.local.entity.ExerciseEntity
import com.example.core.data.local.entity.ExerciseImageEntity
import com.example.core.data.local.entity.ExerciseVideoEntity
import com.example.core.data.remote.api.WgerApiService
import com.example.core.data.remote.dto.ExerciseDTO
import com.example.core.data.remote.dto.ExerciseImageDTO
import com.example.core.data.remote.dto.ExerciseVideoDTO
import com.example.core.data.remote.dto.IngredientDTO
import com.example.core.data.remote.dto.MealDTO
import com.example.core.data.remote.dto.WeightEntryDTO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WgerRepository @Inject constructor(
    private val apiService: WgerApiService,
    private val exerciseDao: ExerciseDao,
    private val imageDao: ExerciseImageDao,
    private val videoDao: ExerciseVideoDao
) {

    suspend fun getExercises(): List<ExerciseDTO> = apiService.getExercises()
    suspend fun getExerciseImages(id:Int): ExerciseImageDTO = apiService.getExerciseImages(id)
    suspend fun getExerciseVideos(id:Int): ExerciseVideoDTO = apiService.getExerciseVideos(id)
    suspend fun getMeal(): MealDTO = apiService.getMeals()
    suspend fun getIngredients(id:Int): IngredientDTO = apiService.getIngredient(id)
    suspend fun getWeightEntries(): WeightEntryDTO = apiService.getWeightEntries()

    suspend fun saveExercises(exercises: List<ExerciseEntity>) = exerciseDao.insertExercises(exercises)
    suspend fun getExercisesFromDb(): List<ExerciseEntity> = exerciseDao.getAllExercises()

    suspend fun saveExerciseImage(images: List<ExerciseImageEntity>) = imageDao.insertImages(images)
    suspend fun getExerciseImageFromDb(id:Int): ExerciseImageEntity? = imageDao.getExerciseImageById(id)

    suspend fun saveExerciseVideos(videos: List<ExerciseVideoEntity>) = videoDao.insertVideos(videos)
    suspend fun getExerciseVideoFromDb(id:Int): ExerciseVideoEntity? = videoDao.getExerciseVideoById(id)
}
