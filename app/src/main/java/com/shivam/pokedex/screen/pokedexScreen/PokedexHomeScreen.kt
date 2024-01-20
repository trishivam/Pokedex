package com.shivam.pokedex.screen.pokedexScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun PokedexHomeScreen(
    viewModel: PokedexViewModel = hiltViewModel(),
    onImageClicked:(String) -> Unit
) {
    Text(text = "${viewModel.pokemon.name}")
}