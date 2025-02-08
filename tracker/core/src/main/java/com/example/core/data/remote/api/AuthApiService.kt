package com.example.core.data.remote.api

import com.example.core.data.remote.dto.AuthResponseDTO
import com.example.core.data.remote.dto.LoginRequestDTO
import com.example.core.data.remote.dto.RefreshTokenRequestDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApiService {

    @POST("token/")
    @FormUrlEncoded
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<AuthResponseDTO>

    @POST("api/v2/token/refresh/")
    suspend fun refresh(@Body request: RefreshTokenRequestDTO): AuthResponseDTO

    @POST("api/v2/token/verify/")
    suspend fun verify(@Body request: Map<String, String>): Response<Unit>
}