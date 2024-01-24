package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable

@Serializable
data class Emerald(
    val front_default: String,
    val front_shiny: String
)