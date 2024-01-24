package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val name: String,
    val url: String
)