package com.example.core.domain.repository

import android.content.SharedPreferences
import com.example.core.data.remote.api.AuthApiService
import com.example.core.data.remote.dto.LoginRequestDTO
import com.example.core.data.remote.dto.RefreshTokenRequestDTO
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: AuthApiService,
    private val prefs: SharedPreferences
) {
    suspend fun login(username: String, password: String): Result<String> {
        return try {
            val response = api.login(username, password)
            saveTokens(response.body()?.access ?:"", response.body()?.refresh?:"")
            Result.success(response.body()?.access?:"")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun refreshToken(): Result<String> {
        val refreshToken = prefs.getString("refresh_token", null) ?: return Result.failure(Exception("No refresh token"))

        return try {
            val response = api.refresh(RefreshTokenRequestDTO(refreshToken))
            saveAccessToken(response.access)
            Result.success(response.access)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun isTokenValid(): Boolean {
        val accessToken = prefs.getString("access_token", null) ?: return false
        val response = api.verify(mapOf("token" to accessToken))
        return response.isSuccessful
    }

    private fun saveTokens(access: String, refresh: String) {
        prefs.edit()
            .putString("access_token", access)
            .putString("refresh_token", refresh)
            .apply()
    }

    private fun saveAccessToken(access: String) {
        prefs.edit().putString("access_token", access).apply()
    }
}