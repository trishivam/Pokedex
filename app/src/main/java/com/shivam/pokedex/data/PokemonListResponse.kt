package com.shivam.pokedex.data

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
    val results: List<PokemonName>
)