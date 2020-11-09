package com.tomisztomek.kursakademiaandroida.features.characters.domain

import com.tomisztomek.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {

    suspend fun getCharacters(): List<Character>
}