package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable

@Serializable
data class Form(
    val name: String,
    val url: String
)