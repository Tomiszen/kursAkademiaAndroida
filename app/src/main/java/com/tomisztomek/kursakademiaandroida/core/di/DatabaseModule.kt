package com.tomisztomek.kursakademiaandroida.core.di

import androidx.room.Room
import com.tomisztomek.kursakademiaandroida.features.data.AppDatabase
import com.tomisztomek.kursakademiaandroida.features.data.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DatabaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .build()
    }
}