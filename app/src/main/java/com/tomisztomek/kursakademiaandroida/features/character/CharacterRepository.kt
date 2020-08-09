package com.tomisztomek.kursakademiaandroida.features.character

import com.tomisztomek.kursakademiaandroida.features.character.domain.model.Character

interface CharacterRepository {

    suspend fun getCharacters(): List<Character>
}