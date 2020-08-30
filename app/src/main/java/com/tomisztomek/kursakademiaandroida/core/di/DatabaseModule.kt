package com.tomisztomek.kursakademiaandroida.core.di

import androidx.room.Room
import com.tomisztomek.kursakademiaandroida.core.database.AppDatabase
import com.tomisztomek.kursakademiaandroida.core.database.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .build()
    }

    single { get<AppDatabase>().episodeDao() }
    single { get<AppDatabase>().locationDao() }
    single { get<AppDatabase>().characterDao() }
}