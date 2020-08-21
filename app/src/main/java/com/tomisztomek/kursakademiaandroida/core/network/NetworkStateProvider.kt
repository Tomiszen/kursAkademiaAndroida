package com.tomisztomek.kursakademiaandroida.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}