package com.example.notifications.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.notifications.screen.DetailsScreen
import com.example.notifications.screen.MainScreen

const val MY_URI = "https://kenstarry.com"

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
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("message") { type = NavType.StringType }
            ),
            deepLinks = listOf(
                navDeepLink { uriPattern = "$MY_URI/message={message}" }
            )
        ) {

            val arguments = it.arguments
            arguments?.getString("message")?.let { message ->
                DetailsScreen(message = message)
            }

        }
    }

}






















