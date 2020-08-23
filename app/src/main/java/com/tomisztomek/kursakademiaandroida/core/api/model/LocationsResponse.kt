package com.tomisztomek.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class LocationsResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("result") val results: List<LocationRemote>
) {
    companion object
}