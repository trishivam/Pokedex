package com.shivam.pokedex.screen.pokedexScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.pokedex.data.PokemonDataModel
import com.shivam.pokedex.data.PokemonInfoModel
import com.shivam.pokedex.network.PokedexApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

var TAG = "pokemon"
@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val apiService:PokedexApiService
): ViewModel() {
    var loading by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    var pokemonDataList by mutableStateOf(PokemonDataModel())

    init{
        viewModelScope.launch {
//                Log.d(TAG, "getAllPokemons: ${apiService.getAllPokemon()}")
            var pokemonResponse = apiService.getAllPokemon()
            for (pokemon in pokemonResponse.results)
                pokemonDataList = apiService.getPokemon(name = pokemon.name)

        }
        Log.d(TAG, "getPokemons: ${pokemonDataList} ")
    }
}
