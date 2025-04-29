package com.globant.superappexample.presentation.screens

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.andanas.wealthy.presentation.screens.wealthyHome.WealthyScreenApp
import com.globant.superappexample.presentation.screens.home.HomeScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(navController, startDestination = ScreenRoute.HomeScreen.route) {
            composable(route = ScreenRoute.HomeScreen.route) {
                HomeScreen(
                    primaryButtonClicked = {

                    },
                    wealthBannerClicked = {
                        navController.navigate(ScreenRoute.WealthyScreen.route)
                    }
                )
            }
            composable(route = ScreenRoute.WealthyScreen.route,
                enterTransition = {
                    slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Left,
                        tween(500)
                    )
                },
                exitTransition = {
                    slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.Right,
                        tween(500)
                    )
                }
            ) {
                WealthyScreenApp(
                    primaryButtonClicked = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}