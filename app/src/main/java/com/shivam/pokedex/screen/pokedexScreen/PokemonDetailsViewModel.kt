package com.shivam.pokedex.screen.pokedexScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.pokedex.data.PokemonDataResponse
import com.shivam.pokedex.network.PokedexApiService
import com.shivam.pokedex.utils.PokemonTypeUtils.getTypeColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.net.UnknownHostException
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val apiService: PokedexApiService
) : ViewModel() {
    var loading by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    var pokemoninfo by mutableStateOf(PokemonDataResponse())
    fun getColor(typeName: String): Color{
        return getTypeColor(typeName)
    }
    fun getPokemonInfo(name :String)
    {
        loading = true
        viewModelScope.launch {
            try {
                var data = apiService.getPokemon(name = name)
                Log.d(TAG, "getPokemonInfo: ${data}")
                pokemoninfo = data
                Log.d(TAG, "getPokemonInformation: ${pokemoninfo}")
            }
            catch (e: UnknownHostException){
                errorMessage = "Check your Internet"
                e.printStackTrace()
            }
            catch (e: Exception) {
                errorMessage= "Something went wrong"
                e.printStackTrace()
            }
            loading = false
        }
    }

}