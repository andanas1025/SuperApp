package com.globant.superappexample.presentation.screens

sealed class ScreenRoute(val route: String) {
    data object HomeScreen : ScreenRoute(route = "home_screen")
    data object WealthyScreen : ScreenRoute(route = "Wealthy_screen")
}