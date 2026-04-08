package com.marchel0036.gradecalculatorapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("mainScreen")
    object About : Screen("aboutScreen")
}