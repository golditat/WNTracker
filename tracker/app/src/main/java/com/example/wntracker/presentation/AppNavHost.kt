package com.example.wntracker.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.feature_auth.presentation.fragments.LoginScreen
import com.example.feature_auth.presentation.viewmodels.AuthViewModel
import com.example.feature_nutritiontest.presentation.fragments.NutritionResultScreen
import com.example.feature_nutritiontest.presentation.fragments.NutritionTestScreen
import com.example.feature_nutritiontest.presentation.viewmodels.NutritionTestViewModel
import com.example.feature_nutritiontracker.presentation.TrackerScreen
import com.example.feature_nutritiontracker.presentation.TrackerViewModel
import com.example.feature_userhome.presentation.fregments.UserHomeScreen
import com.example.feature_userhome.presentation.viewmodels.ProgressViewModel

@Composable
fun AppNavHost(viewModel: AuthViewModel, nutritionTestViewModel: NutritionTestViewModel, progressViewModel: ProgressViewModel, trackerViewModel: TrackerViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        composable("register") {
            val registrationUrl = "https://wger.de/ru/user/registration"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(registrationUrl))
            navController.context.startActivity(intent)
        }

        composable("test"){
            NutritionTestScreen(viewModel = nutritionTestViewModel, navController = navController)
        }

        composable("nutritionResult"){
            NutritionResultScreen(viewModel = nutritionTestViewModel, navController = navController)
        }
        composable("home") {
            UserHomeScreen(viewModel = progressViewModel)
        }
        composable("tracker") {
            TrackerScreen(viewModel = trackerViewModel, navController =navController )
        }
    }
}