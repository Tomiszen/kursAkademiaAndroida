package com.tomisztomek.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName
import com.tomisztomek.kursakademiaandroida.features.characters.domain.model.Character
import com.tomisztomek.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import com.tomisztomek.kursakademiaandroida.features.characters.domain.model.CharacterOrigin

data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val characterOriginRemote: CharacterOriginRemote,
    @SerializedName("location") val characterLocationRemote: CharacterLocationRemote,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        location = characterLocationRemote.toCharacterLocation(),
        origin = characterOriginRemote.toCharacterOrigin(),
        image = image,
        episode = episode,
        url = url
    )
}

data class CharacterOriginRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharacterOrigin() = CharacterOrigin(
        name = name,
        url = url
    )
}

data class CharacterLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    companion object

    fun toCharacterLocation() = CharacterLocation(
        name = name,
        url = url
    )
}