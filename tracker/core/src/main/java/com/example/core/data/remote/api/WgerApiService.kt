package com.example.core.data.remote.api


import com.example.core.data.remote.dto.AuthResponseDTO
import com.example.core.data.remote.dto.EquipmentDTO
import com.example.core.data.remote.dto.ExerciseDTO
import com.example.core.data.remote.dto.ExerciseImageDTO
import com.example.core.data.remote.dto.ExerciseVideoDTO
import com.example.core.data.remote.dto.IngredientDTO
import com.example.core.data.remote.dto.LoginRequestDTO
import com.example.core.data.remote.dto.MealDTO
import com.example.core.data.remote.dto.NutritionPlanDTO
import com.example.core.data.remote.dto.NutritionRequestDTO
import com.example.core.data.remote.dto.NutritionResponseDTO
import com.example.core.data.remote.dto.RefreshTokenRequestDTO
import com.example.core.data.remote.dto.WeightEntryDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WgerApiService {

    @POST("token/")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<AuthResponseDTO>

    @POST("token/verify/")
    suspend fun verify(@Body request: Map<String, String>): Response<Unit>

    @GET("exercise/")
    suspend fun getExercises(
        @Query("language") language: Int = 2,
        @Query("category") category: Int? = null,
        @Query("equipment") equipment: Int? = null
    ): List<ExerciseDTO>

    @GET("exercise/{id}/")
    suspend fun getExerciseById(@Path("id") id: Int): ExerciseDTO

    @GET("exerciseimage/")
    suspend fun getExerciseImages(@Query("exercise") exerciseId: Int): ExerciseImageDTO

    @GET("video/")
    suspend fun getExerciseVideos(@Query("exercise") exerciseId: Int): ExerciseVideoDTO

    @GET("nutritionplan/")
    suspend fun getNutritionPlans(): NutritionPlanDTO

    @GET("ingredient/{id}")
    suspend fun getIngredient(@Query("id") id: Int): IngredientDTO

    @GET("meal/")
    suspend fun getMeals(): MealDTO

    @GET("weightentry/")
    suspend fun getWeightEntries(): WeightEntryDTO

    @POST("nutrition/calculate")
    suspend fun calculateCalories(@Body request: NutritionRequestDTO): NutritionResponseDTO
}
