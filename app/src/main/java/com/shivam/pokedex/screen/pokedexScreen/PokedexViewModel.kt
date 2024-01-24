package com.shivam.pokedex.screen.pokedexScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.pokedex.network.PokedexApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

var TAG = "pokemon"

@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val apiService: PokedexApiService
) : ViewModel() {
    init {
        viewModelScope.launch {
            try {
                val pokemonNameList = apiService.getAllPokemon()
                Log.d(TAG, "Received pokemon name list, count: ${pokemonNameList.results.size}")

                pokemonNameList.results.forEach {
                    try {
                        val pokemonData = apiService.getPokemon(it.name)
                        Log.d(TAG, "Received pokemon data: $pokemonData")
                    } catch (e: Exception) {
                        Log.d(TAG, "Received error while fetching Pokemon data for name: ${it.name}")
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                Log.d(TAG, "Error in fetching pokemon list: ${e.message}")
                e.printStackTrace()
            }
        }
    }
}
