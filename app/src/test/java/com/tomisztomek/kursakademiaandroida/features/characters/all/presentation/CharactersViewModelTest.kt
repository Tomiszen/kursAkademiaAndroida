package com.tomisztomek.kursakademiaandroida.features.characters.all.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.tomisztomek.kursakademiaandroida.core.base.UiState
import com.tomisztomek.kursakademiaandroida.core.exception.ErrorMapper
import com.tomisztomek.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.tomisztomek.kursakademiaandroida.features.characters.domain.model.Character
import com.tomisztomek.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.tomisztomek.kursakademiaandroida.features.mock.mock
import com.tomisztomek.kursakademiaandroida.features.utils.ViewModelTest
import com.tomisztomek.kursakademiaandroida.features.utils.getOrAwaitValue
import com.tomisztomek.kursakademiaandroida.features.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharactersViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending

    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.gender shouldBe character.gender
            characterDisplayable.type shouldBe character.type
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}