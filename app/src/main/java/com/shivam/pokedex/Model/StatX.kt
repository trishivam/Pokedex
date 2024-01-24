package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable

@Serializable
data class StatX(
    val name: String,
    val url: String
)