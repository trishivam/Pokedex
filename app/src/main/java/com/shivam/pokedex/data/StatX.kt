package com.shivam.pokedex.data

import kotlinx.serialization.Serializable

@Serializable
data class StatX(
    val name: String,
    val url: String
)