package com.example.feature_nutritiontracker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.FoodRepository
import com.example.core.domain.repository.UserProgressRepository
import com.example.feature_nutritiontracker.utils.Macros
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class TrackerViewModel @Inject constructor(
    private val repository: FoodRepository,
    private val uprepository:UserProgressRepository
) : ViewModel() {

    private val _macronutrientState = MutableLiveData<Macros>()
    val macronutrientState: LiveData<Macros> = _macronutrientState

    private val _totalNutrients = MutableLiveData<UserProgress>()
    val totalNutrients:LiveData<UserProgress> = _totalNutrients

    fun loadMacros() {
        viewModelScope.launch {
            val food = repository.getTodayEntries(Date(System.currentTimeMillis()).toString())
            var macros = Macros(
                food.sumOf { it.calories },
                food.sumOf { it.proteins.toInt() },
                food.sumOf { it.fats.toInt() },
                food.sumOf { it.carbs.toInt() }
            )
            _macronutrientState.postValue(macros)
        }
    }

    fun getTotalMacros(){
        viewModelScope.launch {
            _totalNutrients.postValue(uprepository.getUserProgress())

        }
    }

}

