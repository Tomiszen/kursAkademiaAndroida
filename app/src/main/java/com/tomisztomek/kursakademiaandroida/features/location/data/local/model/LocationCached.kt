package com.tomisztomek.kursakademiaandroida.features.location.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomisztomek.kursakademiaandroida.features.location.domain.model.Location

@Entity
data class LocationCached(
    @PrimaryKey
    val id: Int,
    val dimension: String,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    constructor(location: Location) : this(
        location.id,
        location.dimension,
        location.name,
        location.residents,
        location.type,
        location.url
    )

    companion object

    fun toLocation() = Location(
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}