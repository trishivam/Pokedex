package com.shivam.pokedex.network

import com.shivam.pokedex.data.PokedexDataModel
import com.shivam.pokedex.data.PokedexInformationModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApiService {

    @GET("pokemon/ditto")
    suspend fun getAllPokemon():PokedexDataModel

    @GET("pokemon/ditto/{name}")
    suspend fun getAllPokemonInfomation(@Path("name")name: String): PokedexInformationModel
}