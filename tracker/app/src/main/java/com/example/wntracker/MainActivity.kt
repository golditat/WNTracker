package com.example.wntracker

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.feature_auth.presentation.viewmodels.AuthViewModel
import com.example.feature_nutritiontest.presentation.viewmodels.NutritionTestViewModel
import com.example.feature_userhome.presentation.viewmodels.ProgressViewModel
import com.example.wntracker.presentation.AppNavHost
import com.google.firebase.crashlytics.FirebaseCrashlytics
import dagger.hilt.android.AndroidEntryPoint
import hilt_aggregated_deps._dagger_hilt_android_internal_lifecycle_HiltWrapper_HiltViewModelFactory_ViewModelModule

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        setContent {
            val viewModel: AuthViewModel = hiltViewModel()
            val nutririonvm:NutritionTestViewModel = hiltViewModel()
            val progrvw:ProgressViewModel = hiltViewModel()
            AppNavHost(viewModel = viewModel, nutririonvm, progrvw)
        }
    }
}