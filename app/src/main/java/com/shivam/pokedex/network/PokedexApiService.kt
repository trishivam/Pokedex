package com.shivam.pokedex.network

import com.shivam.pokedex.data.PokedexDataModel
import com.shivam.pokedex.data.PokedexInformationModel
import retrofit2.http.GET
import retrofit2.http.Path

interface PokedexApiService {

    @GET("Volume")
    suspend fun getAllPokemon():PokedexDataModel

    @GET("Volume/{id}")
    suspend fun getAllPokemonInfomation(@Path("id")id: String): PokedexInformationModel
}