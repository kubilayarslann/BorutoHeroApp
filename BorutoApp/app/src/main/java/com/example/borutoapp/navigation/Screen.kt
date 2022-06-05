package com.example.borutoapp.navigation

sealed class Screen(val route: String){
    object Splash: Screen(route = "splash_screen")
    object Welcome: Screen(route = "welcome_screen")
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/{heroId}"){
        fun passHeroId(heroId: Int): String{
            return "detail_screen/$heroId"
        }
    }
    object Search: Screen(route = "search_screen")
}
