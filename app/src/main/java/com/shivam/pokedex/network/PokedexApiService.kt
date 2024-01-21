package com.shivam.pokedex.network

import com.shivam.pokedex.data.AllPokemonResponse
import com.shivam.pokedex.data.PokemonDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApiService {


    @GET("pokemon")
    suspend fun getAllPokemon(): AllPokemonResponse
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonDataModel


}