package com.shivam.pokedex.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
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
    var canPop by remember { mutableStateOf(false) }

    DisposableEffect(navController) {
        val listener = NavController.OnDestinationChangedListener { controller, _, _ ->
            canPop = controller.previousBackStackEntry != null
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = Routes.valueOf(
        backStackEntry?.destination?.route ?: Routes.PokedexScreen.name
    )

    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Routes.PokedexScreen.name,
        ){
        composable(
            route = Routes.PokedexScreen.name
        ){
            entry ->
            PokedexHomeScreen(){
                navController.navigate(route = "${Routes.PokedexInfoScreen.name}/${it}")
            }
        }
        composable(
            route = "${Routes.PokedexInfoScreen.name}/{name}",
            arguments = listOf(navArgument("name"){
                type = NavType.StringType
            })
        ){entry ->
            PokemonDetailsScreen(
                name = entry.arguments?.getString("name","")?:"",
                onBackButtonClicked = { navController.popBackStack() }
            )
        }
    }
}