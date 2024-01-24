package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable

@Serializable
data class Species(
    val name: String,
    val url: String
)