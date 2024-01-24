package com.shivam.pokedex.network

import com.shivam.pokedex.Model.AllPokemonResponse
import com.shivam.pokedex.Model.PokemonData
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApiService {

    @GET("pokemon")
    suspend fun getAllPokemon(): AllPokemonResponse
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonData


}