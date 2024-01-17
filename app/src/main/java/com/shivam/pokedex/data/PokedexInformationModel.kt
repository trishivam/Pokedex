package com.shivam.pokedex.data

data class PokedexInformationModel(
    val id : Int = 0,
    val name: String = "",
    var imageUrl: PokedexDataModel = PokedexDataModel(0,"",""),
    val height: Int = 0,
    val weight: Int = 0,
    val tyes: List<TypeResponse> = emptyList(),
    val hp: Int = 0,
    val attack: Int = 0,
    val defense: Int = 0,
    val speed:Int = 0,
    val exp:Int = 0
)

data class TypeResponse(
    val slot: Int,
    val type: Type
)

data class Type(
    val name: String
)
