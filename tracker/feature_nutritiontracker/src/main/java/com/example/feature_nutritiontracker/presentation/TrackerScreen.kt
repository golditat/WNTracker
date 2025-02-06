package com.example.feature_nutritiontracker.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.core.domain.model.UserProgress
import com.example.feature_nutritiontracker.utils.Macros
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation

@Composable
fun TrackerScreen(viewModel: TrackerViewModel = viewModel()) {
    val cpfc by viewModel.macronutrientState.observeAsState( Macros(0,0,0,0))
    val total by viewModel.totalNutrients.observeAsState(UserProgress(0,0,0,0,0,0,0))
    viewModel.loadMacros()
    viewModel.getTotalMacros()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text("Калорийный трекер", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(16.dp))

        MacronutrientPieChart(
            protein = cpfc.protein.toDouble(),
            fat = cpfc.fats.toDouble(),
            carbs = cpfc.carbs.toDouble()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LinearProgressIndicator(
            progress = (total.calories / cpfc.calories.toFloat()).coerceIn(0f, 1f),
            color = if (cpfc.calories > total.calories ) Color.Red else Color.Green,
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            //items(meals) { meal ->
            //    MealItem(meal = meal)
            //}
        }
    }
}

@Composable
fun MacronutrientPieChart(protein: Double, fat: Double, carbs: Double) {
    val pieData = listOf(
        PieChartData.Slice(value = protein.toFloat(), color = Color.Blue),
        PieChartData.Slice(value = fat.toFloat(), color = Color.Red),
        PieChartData.Slice(value = carbs.toFloat(), color = Color.Green)
    )
    PieChart(
        pieChartData = PieChartData(pieData),
        modifier = Modifier.size(200.dp),
        animation = simpleChartAnimation()
    )
}