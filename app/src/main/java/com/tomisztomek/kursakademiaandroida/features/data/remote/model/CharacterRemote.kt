package com.tomisztomek.kursakademiaandroida.features.data.remote.model

import com.google.gson.annotations.SerializedName
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.Character
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.CharacterLocation
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.CharacterOrigin

data class CharacterRemote(
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("gender") val gender: String,
    @SerializedName("id") val id: Int,
    @SerializedName("image") val image: String,
    @SerializedName("location") val location: CharacterLocation,
    @SerializedName("name") val name: String,
    @SerializedName("origin") val origin: CharacterOrigin,
    @SerializedName("species") val species: String,
    @SerializedName("status") val status: String,
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    fun toCharacter() =
        Character(
            episode = episode,
            gender = gender,
            id = id,
            image = image,
            location = location,
            name = name,
            origin = origin,
            species = species,
            status = status,
            type = type,
            url = url
        )
}

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterLocation() =
        CharacterLocation(
            name = name,
            url = url
        )
}

data class CharacterOriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toCharacterOrigin() =
        CharacterOrigin(
            name = name,
            url = url
        )
}