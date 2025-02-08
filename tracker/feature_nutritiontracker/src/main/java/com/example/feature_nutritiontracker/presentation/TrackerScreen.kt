package com.example.feature_nutritiontracker.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.core.domain.model.Meal
import com.example.core.domain.model.UserProgress
import com.example.feature_nutritiontracker.utils.Macros
import com.github.tehras.charts.piechart.PieChart
import com.github.tehras.charts.piechart.PieChartData
import com.github.tehras.charts.piechart.animation.simpleChartAnimation

@Composable
fun TrackerScreen(viewModel: TrackerViewModel, navController: NavController) {
    val cpfc by viewModel.macronutrientState.observeAsState( Macros(0,0,0,0))
    val total by viewModel.totalNutrients.observeAsState(UserProgress(0,0,0,0,0,0,0, 0))
    val mealsMap by viewModel.mealsMap.collectAsState()
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
            items(mealsMap.size) { meal ->
               MealItem(meal = mealsMap.get(meal)?: emptyList())
            }
        }
        AddMealFAB( {navController.navigate("add")})
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

@Composable
fun MealItem(meal: List<Meal>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            meal.forEach { ingredient ->
                Text("${ingredient}: ${ingredient.calories * (ingredient.weightUnit?:1)} ккал")
            }
        }
    }
}
@Composable
fun AddMealFAB(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .padding(16.dp)
            .size(56.dp),
        shape = CircleShape
    ) {
        Text(text = "Add")
    }
}