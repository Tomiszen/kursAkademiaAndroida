package com.tomisztomek.kursakademiaandroida.features.characters.di

import com.tomisztomek.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.tomisztomek.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.tomisztomek.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.CharacterAdapter
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.CharacterFragment
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.CharactersViewModel
import com.tomisztomek.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment
import com.tomisztomek.kursakademiaandroida.features.characters.details.presentation.CharacterViewModel
import com.tomisztomek.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.tomisztomek.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }

    scope(named<CharacterFragment>()) {
        viewModel { CharactersViewModel(get(), get(), get()) }
        factory { CharacterAdapter() }
    }

    scope(named<CharacterDetailsFragment>()) {
        viewModel { CharacterViewModel() }
    }
}