package com.tomisztomek.kursakademiaandroida.features.character.domain

import com.tomisztomek.kursakademiaandroida.core.base.UseCase
import com.tomisztomek.kursakademiaandroida.features.character.CharacterRepository
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}