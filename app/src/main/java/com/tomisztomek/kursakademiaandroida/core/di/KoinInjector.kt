package com.tomisztomek.kursakademiaandroida.core.di

import org.koin.core.module.Module

val koinInjecton: List<Module> = featureModules
    .plus(networkModule)
    .plus(databaseModule)
    .plus(appModule)

