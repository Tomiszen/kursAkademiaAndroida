package com.tomisztomek.kursakademiaandroida.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomisztomek.kursakademiaandroida.core.network.NetworkStateProvider
import com.tomisztomek.kursakademiaandroida.core.network.NetworkStateProviderImpl
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

    factory {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
}