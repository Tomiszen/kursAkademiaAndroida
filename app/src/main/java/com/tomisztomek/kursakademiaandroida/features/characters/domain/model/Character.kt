package com.tomisztomek.kursakademiaandroida.features.characters.domain.model

class Character(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: CharacterOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    companion object
}

class CharacterLocation(
    val name: String,
    val url: String
) {
    companion object
}

class CharacterOrigin(
    val name: String,
    val url: String
) {
    companion object
}