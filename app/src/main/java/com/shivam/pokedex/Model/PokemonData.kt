package com.shivam.pokedex.Model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable



@Serializable
data class PokemonData(
    val abilities: List<Ability> =  emptyList(),
    val base_experience: Int = 0,

    val forms: List<Form> = emptyList(),
//    val game_indices: List<GameIndice> = emptyList(),
    val height: Int = 0,
//    val held_items: List<HeldItem> = emptyList(),
    val id: Int = 0,
    val is_default: Boolean = false,
    val location_area_encounters: String = "",
//    val moves: List<Move> = emptyList(),
    val name: String = "",
    val order: Int = 0,
//    val past_abilities: List<Any> = emptyList(),
//    val past_types: List<Any> = emptyList(),
    val species: Species = Species("",""),
    val sprites: Sprites = Sprites("","","","","","","","","","",),
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)