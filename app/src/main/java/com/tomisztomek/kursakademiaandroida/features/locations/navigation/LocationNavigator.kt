package com.tomisztomek.kursakademiaandroida.features.locations.navigation

import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}