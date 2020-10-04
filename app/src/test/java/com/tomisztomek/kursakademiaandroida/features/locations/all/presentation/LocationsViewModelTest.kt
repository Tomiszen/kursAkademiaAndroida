package com.tomisztomek.kursakademiaandroida.features.locations.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.tomisztomek.kursakademiaandroida.core.base.UiState
import com.tomisztomek.kursakademiaandroida.core.exception.ErrorMapper
import com.tomisztomek.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.tomisztomek.kursakademiaandroida.features.locations.domain.model.Location
import com.tomisztomek.kursakademiaandroida.features.locations.navigation.LocationNavigator
import com.tomisztomek.kursakademiaandroida.features.mock.mock
import com.tomisztomek.kursakademiaandroida.features.utils.ViewModelTest
import com.tomisztomek.kursakademiaandroida.features.utils.getOrAwaitValue
import com.tomisztomek.kursakademiaandroida.features.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test


internal class LocationsViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN location live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending

    }

    @Test
    fun `WHEN location live data is observed THEN invoke use case to get locations`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        //given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name shouldBe location.name
            locationDisplayable.dimension shouldBe location.dimension
            locationDisplayable.type shouldBe location.type
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}
