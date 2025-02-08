package com.example.core.domain.usecase

import com.example.core.data.remote.dto.AuthResponseDTO
import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUsecase @Inject constructor(private val repo:AuthRepository) {
    suspend operator fun invoke(username:String, pass:String):Result<String> {
        return repo.login(username, pass)
    }
}