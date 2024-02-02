package com.shivam.pokedex.screen.pokedexScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.pokedex.data.PokemonDataResponse
import com.shivam.pokedex.network.PokedexApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject

var TAG = "pokemon"
@HiltViewModel
class PokedexViewModel @Inject constructor(
    private val apiService:PokedexApiService
): ViewModel() {
    var loading by mutableStateOf(false)
    var errorMessage by mutableStateOf("")


    var pokemondataList = mutableStateListOf<PokemonDataResponse>()

    var pokemon by mutableStateOf(PokemonDataResponse)
    fun getPokemonByName(name: String){
        loading = true
        viewModelScope.launch {
                try {
                    val pokemonData = apiService.getPokemon(name)
//                    pokemon = pokemonData
                } catch (e: UnknownHostException) {
                    errorMessage = "Received error while fetching Pokemon data for name"
                    e.printStackTrace()
                }
                catch (e: Exception){
                    errorMessage = "Error in fetching pokemon list"
                    e.printStackTrace()
                }
            }
        loading = false
        }
    init {
        getAllPokemons()
    }

    private fun getAllPokemons(){
        loading = true
        viewModelScope.launch {
            var pokemonNameList = apiService.getAllPokemon()
//            Log.d(TAG, "PokemonNameList: ${pokemonNameList.results.size}")
            pokemonNameList.results.forEach {
                try {
                    val pokemonData = apiService.getPokemon(it.name)
//                    Log.d(TAG, "getPokemons: ${pokemonData}")
                    pokemondataList.add(pokemonData)
//                    Log.d(TAG, "getAllPokemons: ${pokemondataList}")
                } catch (e: UnknownHostException) {
                    errorMessage = "Received error while fetching Pokemon data for name"
                    e.printStackTrace()
                }
                catch (e: Exception){
                    errorMessage = "Error in fetching pokemon list"
//                    Log.d(TAG, "Error in fetching pokemon list: ${e.message}")
                    e.printStackTrace()
                }
            }
        }
        loading = false
    }
}
