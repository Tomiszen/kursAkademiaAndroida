package com.tomisztomek.kursakademiaandroida.core.di

import com.tomisztomek.kursakademiaandroida.features.character.di.characterModule
import com.tomisztomek.kursakademiaandroida.features.episodes.di.episodeModule
import com.tomisztomek.kursakademiaandroida.features.location.di.locationModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule,
    characterModule,
    locationModule
)