package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable

@Serializable
data class AllPokemonResponse(
    val results: List<PokemonResponse>
)