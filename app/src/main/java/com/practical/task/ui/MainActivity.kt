package com.practical.task.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.practical.task.navigation.Navigation
import com.practical.task.ui.viewmodels.MainActivityViewModel
import com.practical.task.ui.theme.PracticalTaskAndroid
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val splashViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*installSplashScreen().apply {
            setKeepOnScreenCondition { splashViewModel.isLoading.value }
        }
*/
        setContent {
            PracticalTaskAndroid {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    Navigation(navController = navController)
}