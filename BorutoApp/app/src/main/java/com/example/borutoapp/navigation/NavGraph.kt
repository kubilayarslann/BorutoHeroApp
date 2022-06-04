package com.example.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SearchScreen.route
    ) {

        composable(route = Screen.SplashScreen.route) {

        }

        composable(route = Screen.WelcomeScreen.route) {

        }

        composable(route = Screen.HomeScreen.route) {

        }

        composable(route = Screen.DetailScreen.route,
                   arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }

        composable(route = Screen.SearchScreen.route) {

        }

    }
}