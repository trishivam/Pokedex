package com.shivam.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shivam.pokedex.screen.pokedexScreen.PokedexHomeScreen
import com.shivam.pokedex.screen.pokedexScreen.PokemonDetailsScreen

enum class Routes {
    PokedexScreen,
    PokedexInfoScreen
}
@Composable
fun NavigationHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.PokedexScreen.name,
    ) {
        composable(
            route = Routes.PokedexScreen.name
        ) { entry ->
            PokedexHomeScreen(){
                navController.navigate(route = "${Routes.PokedexInfoScreen.name}/${it}")

            }
        }
        composable(
            route = "${Routes.PokedexInfoScreen.name}/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ) {entry ->
            PokemonDetailsScreen(
                name = entry.arguments?.getString("name","")?:"",
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
    }
}