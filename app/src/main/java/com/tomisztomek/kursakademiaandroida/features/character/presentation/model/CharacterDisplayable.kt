package com.tomisztomek.kursakademiaandroida.features.character.presentation.model

import com.tomisztomek.kursakademiaandroida.features.character.domain.model.Character
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.CharacterLocation
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.CharacterOrigin

class CharacterDisplayable(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocationDisplayable,
    val name: String,
    val origin: CharacterOriginDisplayable,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    constructor(character: Character) : this(
        episode = character.episode,
        gender = character.gender,
        id = character.id,
        image = character.image,
        location = CharacterLocationDisplayable(
            character.location
        ),
        name = character.name,
        origin = CharacterOriginDisplayable(
            character.origin
        ),
        species = character.species,
        status = character.status,
        type = character.type,
        url = character.url
    )

}

class CharacterLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterLocation: CharacterLocation) : this(
        name = characterLocation.name,
        url = characterLocation.url
    )
}

class CharacterOriginDisplayable(
    val name: String,
    val url: String
) {
    constructor(characterOrigin: CharacterOrigin) : this(
        name = characterOrigin.name,
        url = characterOrigin.url
    )
}