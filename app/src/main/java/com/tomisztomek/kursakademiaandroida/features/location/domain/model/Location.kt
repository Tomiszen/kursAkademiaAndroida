package com.tomisztomek.kursakademiaandroida.features.location.domain.model

class Location(
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
) {
    companion object
}