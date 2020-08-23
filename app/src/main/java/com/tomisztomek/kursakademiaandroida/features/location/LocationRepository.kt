package com.tomisztomek.kursakademiaandroida.features.location

import com.tomisztomek.kursakademiaandroida.features.location.domain.model.Location

interface LocationRepository {

    suspend fun getLocations(): List<Location>
}