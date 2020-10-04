package com.tomisztomek.kursakademiaandroida.features.characters.data.repository

import com.tomisztomek.kursakademiaandroida.core.api.RickAndMortyApi
import com.tomisztomek.kursakademiaandroida.core.api.model.CharactersResponse
import com.tomisztomek.kursakademiaandroida.core.exception.ErrorWrapper
import com.tomisztomek.kursakademiaandroida.core.network.NetworkStateProvider
import com.tomisztomek.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.tomisztomek.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.tomisztomek.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.tomisztomek.kursakademiaandroida.features.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class CharacterRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN characters request THEN fetch characters from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { api.getCharacters() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN characters request THEN save characters to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getCharacters() } returns CharactersResponse.mock()
        }
        val characterDao = mockk<CharacterDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { characterDao.saveCharacters(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN characters request THEN fetch characters from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val characterDao = mockk<CharacterDao>(relaxed = true) {
            coEvery { getCharacters() } returns listOf(
                CharacterCached.mock(),
                CharacterCached.mock()
            )
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: CharacterRepository =
            CharacterRepositoryImpl(api, characterDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getCharacters() }

        //then
        coVerify { characterDao.getCharacters() }
    }
}