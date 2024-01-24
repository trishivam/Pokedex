package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable


data class GameIndice(
    val game_index: Int,
    val version: Version
)