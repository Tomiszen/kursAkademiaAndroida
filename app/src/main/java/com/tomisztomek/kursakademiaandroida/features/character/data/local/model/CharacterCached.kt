package com.tomisztomek.kursakademiaandroida.features.character.data.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.Character
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.CharacterLocation
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.CharacterOrigin

@Entity
data class CharacterCached(
    @PrimaryKey
    val id: Int,
    val episode: List<String>,
    val gender: String,
    val image: String,
    @Embedded
    val characterLocationCached: CharacterLocationCached,
    val name: String,
    @Embedded
    val characterOriginCached: CharacterOriginCached,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        character.id,
        character.episode,
        character.gender,
        character.image,
        CharacterLocationCached(character.location),
        character.name,
        CharacterOriginCached(character.origin),
        character.species,
        character.status,
        character.type,
        character.url
    )

    companion object

    fun toCharacter() =
        Character(
            id = id,
            episode = episode,
            gender = gender,
            image = image,
            location = characterLocationCached.toCharacterLocation(),
            name = name,
            origin = characterOriginCached.toCharacterOrigin(),
            species = species,
            status = status,
            type = type,
            url = url
        )
}

data class CharacterLocationCached(
    val locationName: String,
    val locationUrl: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        characterLocation.name,
        characterLocation.url
    )

    companion object

    fun toCharacterLocation() =
        CharacterLocation(
            name = locationName,
            url = locationUrl
        )
}

data class CharacterOriginCached(
    val originName: String,
    val originUrl: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        characterOrigin.name,
        characterOrigin.url
    )

    companion object

    fun toCharacterOrigin() =
        CharacterOrigin(
            name = originName,
            url = originUrl
        )
}

