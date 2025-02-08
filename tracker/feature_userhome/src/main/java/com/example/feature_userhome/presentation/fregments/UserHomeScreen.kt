package com.example.feature_userhome.presentation.fregments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.domain.model.History
import com.example.feature_userhome.presentation.viewmodels.ProgressViewModel
import com.github.tehras.charts.line.LineChart
import com.github.tehras.charts.line.LineChartData
import com.github.tehras.charts.line.renderer.line.SolidLineDrawer
import com.github.tehras.charts.line.renderer.point.FilledCircularPointDrawer
import com.github.tehras.charts.piechart.animation.simpleChartAnimation

@Composable
fun UserHomeScreen(viewModel: ProgressViewModel) {
    val weightHistory by viewModel.weightHistory.observeAsState(emptyList())
    var newWeight by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "История веса", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        WeightChart(weightHistory)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = newWeight,
            onValueChange = { newWeight = it },
            label = { Text("Новый вес") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            newWeight.toFloatOrNull()?.let {
                viewModel.addWeight(it.toInt())
                viewModel.getHistory()
                newWeight = ""
            }
        }) {
            Text("Сохранить")
        }
    }
}
@Composable
fun WeightChart(weightHistory: List<History>) {
    if (weightHistory.isEmpty()) {
        Text(text = "Нет данных для отображения", fontSize = 16.sp)
        return
    }

    val entries = weightHistory.map { it.date to it.weight }

    LineChart(
        linesChartData = listOf(
            LineChartData(
                points = weightHistory.mapIndexed { index, weight ->
                    LineChartData.Point( weight.weight.toFloat(), weight.date)
                },
                lineDrawer = SolidLineDrawer()
            )
        ),
        modifier = Modifier.fillMaxWidth().height(300.dp),
        animation = simpleChartAnimation(),
        pointDrawer = FilledCircularPointDrawer(),
        horizontalOffset = 5f,
        labels = weightHistory.map { it.date }
    )
}