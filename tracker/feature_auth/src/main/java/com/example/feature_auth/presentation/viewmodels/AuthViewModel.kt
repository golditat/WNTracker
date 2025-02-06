package com.example.feature_auth.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    private val _authState = MutableLiveData<Result<String>>()
    val authState: LiveData<Result<String>> get() = _authState


    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = repository.login(username, password)
            _authState.postValue(result)
        }
    }

    fun refreshToken() {
        viewModelScope.launch {
            val result = repository.refreshToken()
            _authState.postValue(result)
        }
    }

}