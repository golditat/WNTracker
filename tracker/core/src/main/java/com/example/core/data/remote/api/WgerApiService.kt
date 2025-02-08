package com.example.core.data.remote.api


import com.example.core.data.local.utils.PagedResponse
import com.example.core.data.remote.dto.AuthResponseDTO
import com.example.core.data.remote.dto.EquipmentDTO
import com.example.core.data.remote.dto.ExerciseDTO
import com.example.core.data.remote.dto.ExerciseImageDTO
import com.example.core.data.remote.dto.ExerciseVideoDTO
import com.example.core.data.remote.dto.IngredientDTO
import com.example.core.data.remote.dto.LoginRequestDTO
import com.example.core.data.remote.dto.MealRequestDTO
import com.example.core.data.remote.dto.MealResponseDTO
import com.example.core.data.remote.dto.NutritionDiaryRequestDTO
import com.example.core.data.remote.dto.NutritionDiaryResponseDTO
import com.example.core.data.remote.dto.NutritionPlanRequestDTO
import com.example.core.data.remote.dto.NutritionPlanResponseDTO
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

    @POST("nutritionplan/")
    suspend fun createNutritionPlan(@Body plan: NutritionPlanRequestDTO): Response<NutritionPlanResponseDTO>

    @GET("ingredient/{id}/get_values/")
    suspend fun getIngredient(@Query("id") id: Int): IngredientDTO

    @GET("weightentry/")
    suspend fun getWeightEntries(): WeightEntryDTO

    @GET("nutritiondiary/")
    suspend fun getNutritionDiary(
        @Query("datetime__date") date: String
    ): Response<PagedResponse<NutritionDiaryResponseDTO>>

    @POST("nutritiondiary/")
    suspend fun createNutritionDiary(
        @Body request: NutritionDiaryRequestDTO
    ): Response<NutritionDiaryResponseDTO>

    @GET("meal/")
    suspend fun getMeals(
        @Query("nutrition_plan") planId: Int
    ): Response<PagedResponse<MealResponseDTO>>

    @POST("meal/")
    suspend fun createMeal(
        @Body request: MealRequestDTO
    ): Response<MealResponseDTO>
}
