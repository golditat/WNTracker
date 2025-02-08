package com.example.feature_auth.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.repository.AuthRepository
import com.example.core.domain.usecase.LoginUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val usecase: LoginUsecase
) : ViewModel() {

    private val _authState = MutableLiveData<Result<String>>()
    val authState: LiveData<Result<String>> get() = _authState


    fun login(username: String, password: String) {
        viewModelScope.launch {
            val result = usecase(username, password)
            _authState.postValue(result)
        }
    }

}