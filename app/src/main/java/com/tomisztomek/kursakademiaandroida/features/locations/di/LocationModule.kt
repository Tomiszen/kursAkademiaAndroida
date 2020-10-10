package com.tomisztomek.kursakademiaandroida.features.locations.di

import com.tomisztomek.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.tomisztomek.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import com.tomisztomek.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.tomisztomek.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.tomisztomek.kursakademiaandroida.features.locations.domain.LocationRepository
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.LocationAdapter
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.LocationFragment
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.LocationsViewModel
import com.tomisztomek.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment
import com.tomisztomek.kursakademiaandroida.features.locations.details.presentation.LocationViewModel
import com.tomisztomek.kursakademiaandroida.features.locations.navigation.LocationNavigator
import com.tomisztomek.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationsViewModel(get(), get(), get()) }
    viewModel { LocationViewModel() }
    factory { LocationFragment() }
    factory { LocationDetailsFragment() }
    factory { LocationAdapter(get()) }
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }
}