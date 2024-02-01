package com.shivam.pokedex.data

import kotlinx.serialization.Serializable

@Serializable
data class PokemonDataResponse(
    val base_experience: Int = 0,
    val height: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val species: Species = Species("",""),
    val sprites: Sprites = Sprites(""),
    val stats: List<Stat> = emptyList(),
    val types: List<Type> = emptyList(),
    val weight: Int = 0
)