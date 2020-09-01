package com.tomisztomek.kursakademiaandroida.features.episodes.di

import com.tomisztomek.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.tomisztomek.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.tomisztomek.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.tomisztomek.kursakademiaandroida.features.episodes.presentation.EpisodeAdapter
import com.tomisztomek.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import com.tomisztomek.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get(), get()) }
    factory { EpisodeFragment() }
    factory { EpisodeAdapter() }
}