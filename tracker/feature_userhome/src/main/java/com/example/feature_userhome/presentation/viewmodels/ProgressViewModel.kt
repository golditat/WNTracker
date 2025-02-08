package com.example.feature_userhome.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.History
import com.example.core.domain.repository.HistoryRepository
import com.example.core.domain.usecase.GetHistoryUseCase
import com.example.core.domain.usecase.SaveHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class ProgressViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase,
    private val saveHistoryUseCase: SaveHistoryUseCase
) : ViewModel() {

    val weightHistory: LiveData<List<History>> get() = _currentHistory
    private val _currentHistory = MutableLiveData<List<History>>()
    private val _currentWeight = MutableLiveData<Float>()
    val currentWeight: LiveData<Float> get() = _currentWeight

    fun getHistory(){
        viewModelScope.launch {
           _currentHistory.value = getHistoryUseCase()
        }
    }
    fun addWeight(weight: Int){
        viewModelScope.launch {
            saveHistory(Date(System.currentTimeMillis()))
            getHistory()
        }
    }

    suspend fun saveHistory(date: Date) {
       saveHistoryUseCase(History(0,(_currentWeight.value?.toInt()?:0), date.toString()))
    }
}