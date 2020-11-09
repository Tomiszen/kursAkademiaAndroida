package com.tomisztomek.kursakademiaandroida.features.locations.domain

import com.tomisztomek.kursakademiaandroida.core.base.UseCase
import com.tomisztomek.kursakademiaandroida.features.locations.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}