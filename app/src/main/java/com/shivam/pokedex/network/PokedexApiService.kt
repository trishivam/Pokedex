package com.shivam.pokedex.network

import com.shivam.pokedex.data.PokemonDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApiService {

    @GET("pokemon")
    suspend fun getAllPokemon(): PokemonDataModel

//    @GET("")
//    suspend fun getAllPokemonInfomation(@Path("name")name: String): PokedexInformationModel
}