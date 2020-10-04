package com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model

import android.os.Parcelable
import com.tomisztomek.kursakademiaandroida.features.locations.domain.model.Location
import kotlinx.android.parcel.Parcelize

@Parcelize
class LocationDisplayable(
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
): Parcelable {
    constructor(location: Location) : this(
        dimension = location.dimension,
        id = location.id,
        name = location.name,
        residents = location.residents,
        type = location.type,
        url = location.url
    )
    companion object
}


