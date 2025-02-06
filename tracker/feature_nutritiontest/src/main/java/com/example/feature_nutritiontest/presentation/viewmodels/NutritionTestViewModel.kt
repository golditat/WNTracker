package com.example.feature_nutritiontest.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.core.domain.model.UserProgress
import com.example.core.domain.repository.UserProgressRepository
import com.example.feature_nutritiontest.utils.Nutrition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutritionTestViewModel @Inject constructor(
    private val repository: UserProgressRepository
) : ViewModel() {

    private val _currentStep = MutableLiveData(0)
    val currentStep: LiveData<Int> get() = _currentStep

    private val _gender = MutableLiveData<String>()
    private val _age = MutableLiveData<Int>()
    private val _height = MutableLiveData<Int>()
    private val _weight = MutableLiveData<Int>()
    private val _activityLevel = MutableLiveData<String>()
    private val _goal = MutableLiveData<String>()

    fun nextStep() {
        _currentStep.value = (_currentStep.value ?: 0) + 1
    }

    fun setAnswer(answer: Any) {
        when (_currentStep.value) {
            0 -> _gender.value = answer as String
            1 -> _age.value = answer as Int
            2 -> _height.value = answer as Int
            3 -> _weight.value = answer as Int
            4 -> _activityLevel.value = answer as String
            5 -> _goal.value = answer as String
        }
    }

    fun calculateCalories():Nutrition{
          val bmr = if (_gender.value.equals("Мужской")) {
                88.36 + (13.4 * (_weight.value?:0)) + (4.8 * (_height.value?:0)) - (5.7 * (_age.value?:0))
            } else {
                447.6 + (9.2 * (_weight.value?:0)) + (3.1 * (_height.value?:0)) - (4.3 * (_age.value?:0))
            }

            val activityMultiplier = when (_activityLevel.value) {
                "Низкая" -> 1.2
                "Средняя" -> 1.55
                "Высокая" -> 1.725
                else -> 1.2
            }

        val ccalperc = when (_goal.value) {
            "Похудение" -> 0.8
            "Поддержание веса" -> 1.0
            "Набор массы" -> 1.2
            else -> 1.0
        }
        val calories =  (bmr * activityMultiplier * ccalperc).toInt()
        val (proteinPercent, fatPercent, carbPercent) = when (_goal.value) {
            "Похудение" -> Triple(0.40, 0.25, 0.35)  // Больше белка, меньше углеводов
            "Поддержание веса" -> Triple(0.30, 0.25, 0.45) // Сбалансированное питание
            "Набор массы" -> Triple(0.25, 0.30, 0.45) // Больше углеводов и жиров
            else -> Triple(0.30, 0.25, 0.45) // Значения по умолчанию (поддержание веса)
        }

        val protein = ((calories * proteinPercent) / 4).toInt()
        val fats = ((calories * fatPercent) / 9).toInt()
        val carbs = ((calories * carbPercent) / 4).toInt()
        viewModelScope.launch {
            repository.insertUserProgress(UserProgress(0,(_weight.value?.toInt()?:0), (_height.value?.toInt()?:0), calories, protein, fats, carbs))
        }
        return Nutrition(calories, protein, fats, carbs)
    }
}
