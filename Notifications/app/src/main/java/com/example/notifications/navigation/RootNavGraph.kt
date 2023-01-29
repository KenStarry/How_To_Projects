package com.example.notifications.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notifications.screen.MainScreen

@Composable
fun RootNavGraph(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.Main.route
    ) {

        composable(route = Screen.Main.route) {
            MainScreen(navHostController = navHostController)
        }

        composable(
            route = Screen.Details.route
        ) {

        }
    }

}






















