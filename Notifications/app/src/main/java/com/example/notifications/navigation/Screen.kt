package com.example.notifications.navigation

sealed class Screen(
    val route: String
) {

    object Main : Screen("main_screen")

    object Details : Screen("details_screen/{message}") {
        fun passMessage(message: String) = "details_screen/$message"
    }


}
