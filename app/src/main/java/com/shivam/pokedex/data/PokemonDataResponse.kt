package com.shivam.pokedex.data

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDataResponse(
    val name: String,
    val sprites: PokemonSprites
)
