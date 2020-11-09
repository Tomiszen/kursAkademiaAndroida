package com.tomisztomek.kursakademiaandroida.core.di

import com.tomisztomek.kursakademiaandroida.features.characters.di.characterModule
import com.tomisztomek.kursakademiaandroida.features.episodes.di.episodeModule
import com.tomisztomek.kursakademiaandroida.features.locations.di.locationModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule,
    characterModule,
    locationModule
)