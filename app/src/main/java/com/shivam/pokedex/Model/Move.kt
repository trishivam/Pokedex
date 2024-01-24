package com.shivam.pokedex.Model

import kotlinx.serialization.Serializable


data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)