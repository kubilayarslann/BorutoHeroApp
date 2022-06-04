package com.example.borutoapp.navigation

sealed class Screen(val route: String){
    object SplashScreen: Screen(route = "splash_screen")
    object WelcomeScreen: Screen(route = "welcome_screen")
    object HomeScreen: Screen(route = "home_screen")
    object DetailScreen: Screen(route = "detail_screen/{heroId}"){
        fun passHeroId(heroId: Int): String{
            return "detail_screen/$heroId"
        }
    }
    object SearchScreen: Screen(route = "search_screen")
}
