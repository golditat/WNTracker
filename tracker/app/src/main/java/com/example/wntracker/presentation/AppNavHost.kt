package com.example.wntracker.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.feature_auth.presentation.fragments.LoginScreen
import com.example.feature_auth.presentation.fragments.RegisterScreen
import com.example.feature_auth.presentation.viewmodels.AuthViewModel
import com.example.feature_nutritiontest.presentation.fragments.NutritionResultScreen
import com.example.feature_nutritiontest.presentation.fragments.NutritionTestScreen
import com.example.feature_nutritiontest.presentation.viewmodels.NutritionTestViewModel
import com.example.feature_userhome.presentation.fregments.UserHomeScreen
import com.example.feature_userhome.presentation.viewmodels.ProgressViewModel

@Composable
fun AppNavHost(viewModel: AuthViewModel, nutritionTestViewModel: NutritionTestViewModel, progressViewModel: ProgressViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(viewModel = viewModel, navController = navController)
        }

        composable("register") {
            RegisterScreen(viewModel = viewModel, navController = navController)
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

    }
}
