package com.example.feature_userhome.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.History
import com.example.core.domain.repository.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class ProgressViewModel @Inject constructor(
    private val repository: HistoryRepository
) : ViewModel() {

    val weightHistory: LiveData<List<History>> = liveData { getHistory()}

    private val _currentWeight = MutableLiveData<Float>()
    val currentWeight: LiveData<Float> get() = _currentWeight

    suspend fun getHistory(): List<History> {
        var history: List<History> = repository.getHistory()
        return history
    }
    fun addWeight(weight: Int){
        viewModelScope.launch {
            saveHistory(Date(System.currentTimeMillis()))
            getHistory()
        }
    }

    suspend fun saveHistory(date: Date) {
       repository.saveHistory(History(0,(_currentWeight.value?.toInt()?:0), date.toString()))
    }
}