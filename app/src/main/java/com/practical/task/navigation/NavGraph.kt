package com.practical.task.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.practical.task.ui.screens.HomeScreen
import com.practical.task.ui.viewmodels.MainActivityViewModel


@Composable
fun Navigation(
    navController: NavHostController
) {

    val viewModel = hiltViewModel<MainActivityViewModel>()
    NavHost(navController, startDestination = Screen.HomeScreen.route) {

        /*composable(
            Screen.MovieDetail.route.plus(Screen.MovieDetail.objectPath),
            arguments = listOf(navArgument(Screen.MovieDetail.objectName) {
                type = NavType.IntType
            })
        ) {

        }*/

        composable(
            Screen.HomeScreen.route
        ) {
            HomeScreen(viewModel =viewModel )
        }
    }
}
