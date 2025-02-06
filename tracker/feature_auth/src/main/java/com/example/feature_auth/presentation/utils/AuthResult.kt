package com.example.feature_auth.presentation.utils

sealed class AuthResult {
    data class Success(val token: String) : AuthResult()
    data class Error(val message: String) : AuthResult()
    object Loading : AuthResult()
}