package com.tomisztomek.kursakademiaandroida.features.character.di

import com.tomisztomek.kursakademiaandroida.features.character.data.repository.CharacterRepositoryImpl
import com.tomisztomek.kursakademiaandroida.features.character.domain.CharacterRepository
import com.tomisztomek.kursakademiaandroida.features.character.domain.GetCharactersUseCase
import com.tomisztomek.kursakademiaandroida.features.character.presentation.CharacterAdapter
import com.tomisztomek.kursakademiaandroida.features.character.presentation.CharacterFragment
import com.tomisztomek.kursakademiaandroida.features.character.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get()) }
    factory { CharacterFragment() }
    factory { CharacterAdapter() }
}