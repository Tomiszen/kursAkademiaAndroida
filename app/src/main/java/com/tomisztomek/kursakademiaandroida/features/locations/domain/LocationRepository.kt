package com.tomisztomek.kursakademiaandroida.features.locations.domain

import com.tomisztomek.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {

    suspend fun getLocations(): List<Location>
}