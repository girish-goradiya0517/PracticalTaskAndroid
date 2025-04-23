package com.practical.task.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.practical.task.R


sealed class Screen(
    val route: String,
    @StringRes val title: Int = R.string.app_name,
    val navIcon: (@Composable () -> Unit) = {
        Icon(
            Icons.Filled.Home, contentDescription = "home"
        )
    },
    val objectName: String = "",
    val objectPath: String = ""
) {
    data object HomeScreen : Screen("HomeScreen")


    /*data object MovieDetail :
        Screen("movie_detail", objectName = "movieItem", objectPath = "/{movieItem}")*/

}