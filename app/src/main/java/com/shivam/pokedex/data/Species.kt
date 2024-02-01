package com.shivam.pokedex.data

import kotlinx.serialization.Serializable


@Serializable
data class Species(
    val name: String,
    val url: String
)