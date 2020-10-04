package com.tomisztomek.kursakademiaandroida.features.locations.data.repository

import com.tomisztomek.kursakademiaandroida.core.api.RickAndMortyApi
import com.tomisztomek.kursakademiaandroida.core.api.model.LocationsResponse
import com.tomisztomek.kursakademiaandroida.core.exception.ErrorWrapper
import com.tomisztomek.kursakademiaandroida.core.network.NetworkStateProvider
import com.tomisztomek.kursakademiaandroida.features.locations.data.local.LocationDao
import com.tomisztomek.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.tomisztomek.kursakademiaandroida.features.locations.domain.LocationRepository
import com.tomisztomek.kursakademiaandroida.features.mock.mock
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

internal class LocationRepositoryImplTest {

    @Test
    fun `GIVEN network is connected WHEN locations request THEN fetch locations from API`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { api.getLocations() }
    }

    @Test
    fun `GIVEN network is connected AND successful data fetch WHEN locations request THEN save locations to local database`() {
        //given
        val api = mockk<RickAndMortyApi> {
            coEvery { getLocations() } returns LocationsResponse.mock()
        }
        val locationDao = mockk<LocationDao>(relaxed = true)
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns true
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.saveLocations(*anyVararg()) }
    }

    @Test
    fun `GIVEN network is disconnected WHEN locations request THEN fetch locations from local database`() {
        //given
        val api = mockk<RickAndMortyApi>(relaxed = true)
        val locationDao = mockk<LocationDao>(relaxed = true) {
            coEvery { getLocations() } returns listOf(LocationCached.mock(), LocationCached.mock())
        }
        val networkStateProvider = mockk<NetworkStateProvider> {
            every { isNetworkAvailable() } returns false
        }
        val errorWrapper = mockk<ErrorWrapper>(relaxed = true)
        val repository: LocationRepository =
            LocationRepositoryImpl(api, locationDao, networkStateProvider, errorWrapper)

        //when
        runBlocking { repository.getLocations() }

        //then
        coVerify { locationDao.getLocations() }
    }
}