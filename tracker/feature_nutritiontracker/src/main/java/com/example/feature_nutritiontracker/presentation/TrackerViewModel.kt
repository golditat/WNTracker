package com.example.feature_nutritiontracker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.remote.dto.NutritionDiaryResponseDTO
import com.example.core.domain.model.FoodEntry
import com.example.core.domain.model.Meal
import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.FoodRepository
import com.example.core.domain.repository.UserProgressRepository
import com.example.core.domain.usecase.CreateNutritionDiaryUseCase
import com.example.core.domain.usecase.GetTodayDiariesUseCase
import com.example.core.domain.usecase.GetTodayEntriesUseCase
import com.example.core.domain.usecase.GetUserProgressUseCase
import com.example.feature_nutritiontracker.utils.Macros
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class TrackerViewModel @Inject constructor(
    private val getTodayDiaryUseCase: GetTodayDiariesUseCase,
    private val getUserProgressUseCase: GetUserProgressUseCase
) : ViewModel() {

    private val _macronutrientState = MutableLiveData<Macros>()
    val macronutrientState: LiveData<Macros> = _macronutrientState

    private val _totalNutrients = MutableLiveData<UserProgress>()
    val totalNutrients:LiveData<UserProgress> = _totalNutrients

    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meals: StateFlow<List<Meal>> = _meals.asStateFlow()

    private val _mealsMap = MutableStateFlow<Map<Int, List<Meal>>>(emptyMap())
    val mealsMap: StateFlow<Map<Int, List<Meal>>> = _mealsMap.asStateFlow()

    init {
        loadMealsForToday()
    }

    private fun groupByMeal(entries: List<Meal>): Map<Int, List<Meal>> {
        return entries.groupBy { it.meal ?: -1 }
    }

    fun loadMealsForToday() {
        viewModelScope.launch {
            getTodayDiaryUseCase(Date(System.currentTimeMillis()).toString()).let{ mealsList ->
                    _meals.value = mealsList
                    _mealsMap.value = groupByMeal(mealsList)
                }
        }
    }

    fun loadMacros() {
        viewModelScope.launch {
            var macros = Macros(
                _meals.value.sumOf { (it.calories * (it.weightUnit?:1)) },
                _meals.value.sumOf { (it.proteins * (it.weightUnit?:1)) },
                _meals.value.sumOf { (it.fats * (it.weightUnit?:1)) },
                _meals.value.sumOf { (it.carbs * (it.weightUnit?:1)) }
            )
            _macronutrientState.postValue(macros)
        }
    }

    fun getTotalMacros(){
        viewModelScope.launch {
            _totalNutrients.postValue(getUserProgressUseCase())
        }
    }

}

