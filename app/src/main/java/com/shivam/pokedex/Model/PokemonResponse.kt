package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    val name: String,
    val url: String
)
