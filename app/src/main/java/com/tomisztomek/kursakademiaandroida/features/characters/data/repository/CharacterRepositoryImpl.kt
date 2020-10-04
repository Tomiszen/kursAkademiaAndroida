package com.tomisztomek.kursakademiaandroida.features.characters.data.repository

import com.tomisztomek.kursakademiaandroida.core.api.RickAndMortyApi
import com.tomisztomek.kursakademiaandroida.core.exception.ErrorWrapper
import com.tomisztomek.kursakademiaandroida.core.exception.callOrThrow
import com.tomisztomek.kursakademiaandroida.core.network.NetworkStateProvider
import com.tomisztomek.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.tomisztomek.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.tomisztomek.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.tomisztomek.kursakademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getCharactersFromRemote() }
                .also { saveCharactersToLocal(it) }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters()
            .results
            .map { it.toCharacter() }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map { CharacterCached(it) }
            .toTypedArray()
            .let { characterDao.saveCharacters(*it) }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters()
            .map { it.toCharacter() }

    }
}