package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable


data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)