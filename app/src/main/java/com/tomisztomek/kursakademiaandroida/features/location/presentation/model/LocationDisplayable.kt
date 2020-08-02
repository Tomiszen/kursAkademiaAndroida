package com.tomisztomek.kursakademiaandroida.features.location.presentation.model

import com.tomisztomek.kursakademiaandroida.features.location.domain.model.Location

class LocationDisplayable(
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(location: Location) : this(
        dimension = location.dimension,
        id = location.id,
        name = location.name,
        residents = location.residents,
        type = location.type,
        url = location.url
    )
}


