package com.tomisztomek.kursakademiaandroida.core.di

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val COLUMNS_COUNTER = 2

val AppModule = module {

    factory {
        LinearLayoutManager(this.androidContext())
    }

    factory {
        GridLayoutManager(this.androidContext(), COLUMNS_COUNTER)
    }

    factory {
        DividerItemDecoration(this.androidContext(), LinearLayoutManager.VERTICAL)
    }
}