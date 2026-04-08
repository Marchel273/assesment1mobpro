package com.marchel0036.gradecalculatorapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.marchel0036.gradecalculatorapp.screen.MainScreen
import com.marchel0036.gradecalculatorapp.screen.AboutScreen

@Composable
fun SetupNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            MainScreen(navController)
        }

        composable(Screen.About.route) {
            AboutScreen(navController)
        }
    }
}