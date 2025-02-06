package com.example.feature_nutritiontest.presentation.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.feature_nutritiontest.presentation.viewmodels.NutritionTestViewModel

@Composable
fun NutritionResultScreen(viewModel: NutritionTestViewModel, navController: NavController) {
    val cal =  viewModel.calculateCalories()
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Ваша дневная калорийность:", style = MaterialTheme.typography.h5)

            Text("Калории: ${cal.calories}")
            Text("Белки: ${cal.protein} г")
            Text("Жиры: ${cal.fats} г")
            Text("Углеводы: ${cal.carbs} г")

        Button(onClick = { navController.navigate("home") }) {
            Text("Продолжить")
        }
    }
}