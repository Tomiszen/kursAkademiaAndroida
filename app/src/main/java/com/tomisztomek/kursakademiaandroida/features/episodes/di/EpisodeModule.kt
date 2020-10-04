package com.tomisztomek.kursakademiaandroida.features.episodes.di

import com.tomisztomek.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.tomisztomek.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.tomisztomek.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.EpisodeAdapter
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.EpisodeFragment
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.EpisodesViewModel
import com.tomisztomek.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.tomisztomek.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodesViewModel(get(), get(), get()) }
    factory { EpisodeFragment() }
    factory { EpisodeAdapter(get()) }
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get())}
}