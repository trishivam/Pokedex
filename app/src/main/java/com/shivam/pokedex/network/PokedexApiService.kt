package com.shivam.pokedex.network

import com.shivam.pokedex.data.PokemonDataResponse
import com.shivam.pokedex.data.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApiService {

    @GET("pokemon")
    suspend fun getAllPokemon(): PokemonListResponse
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonDataResponse
}