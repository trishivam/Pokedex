package com.shivam.pokedex.screen.pokedexScreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shivam.pokedex.data.PokedexDataModel
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
    var pokemon by mutableStateOf(PokedexDataModel())
    var loading by mutableStateOf(false)
    var errorMessage by mutableStateOf("")
    fun getAllPokemon(){
        loading = true
        viewModelScope.launch {
            try {
                var pokemon = apiService.getAllPokemon()
                Log.d(TAG, "getAllPokemon: ${pokemon}")
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
