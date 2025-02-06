package com.example.feature_nutritiontest.presentation.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.feature_nutritiontest.presentation.viewmodels.NutritionTestViewModel

@Composable
fun NutritionTestScreen(viewModel: NutritionTestViewModel, navController: NavController) {
    val currentStep by viewModel.currentStep.observeAsState(0)

    val questions = listOf(
        "Выберите пол" to listOf("Мужской", "Женский"),
        "Укажите ваш возраст" to emptyList(),
        "Укажите ваш рост (см)" to emptyList(),
        "Укажите ваш вес (кг)" to emptyList(),
        "Выберите уровень активности" to listOf("Низкая", "Средняя", "Высокая"),
        "Выберите цель" to listOf("Похудение", "Поддержание веса", "Набор массы")
    )

    val (questionText, options) = questions[currentStep]

    var userInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(questionText, style = MaterialTheme.typography.h5)

        if (options.isNotEmpty()) {
            options.forEach { option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = userInput == option,
                        onClick = { userInput = option }
                    )
                    Text(text = option)
                }
            }
        } else {
            TextField(
                value = userInput,
                onValueChange = { userInput = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }

        Button(onClick = {
            if (userInput.isNotEmpty()) {
                viewModel.setAnswer(if (options.isNotEmpty()) userInput else userInput.toInt())
                if (currentStep == questions.lastIndex) {
                    navController.navigate("nutritionResult")
                } else {
                    viewModel.nextStep()
                    userInput = ""
                }
            }
        }) {
            Text(text = if (currentStep == questions.lastIndex) "Завершить" else "Далее")
        }

    }
}