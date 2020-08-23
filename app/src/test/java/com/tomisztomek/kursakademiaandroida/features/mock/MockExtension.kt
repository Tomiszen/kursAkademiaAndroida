package com.tomisztomek.kursakademiaandroida.features.mock

import com.tomisztomek.kursakademiaandroida.core.api.model.*
import com.tomisztomek.kursakademiaandroida.features.character.data.local.model.CharacterCached
import com.tomisztomek.kursakademiaandroida.features.character.data.local.model.CharacterLocationCached
import com.tomisztomek.kursakademiaandroida.features.character.data.local.model.CharacterOriginCached
import com.tomisztomek.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.tomisztomek.kursakademiaandroida.features.location.data.local.model.LocationCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air Date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    dimension = "location dimension",
    name = "location name",
    id = 1,
    type = "location type",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun LocationsResponse.Companion.mock() = LocationsResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    dimension = "location dimension",
    name = "location name",
    id = 1,
    type = "location type",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    episode = emptyList(),
    gender = "character gender",
    id = 1,
    image = "character image",
    characterLocationRemote = CharacterLocationRemote.mock(),
    name = "character name",
    characterOriginRemote = CharacterOriginRemote.mock(),
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url",
    created = "character created"
)

@TestOnly
fun CharacterLocationRemote.Companion.mock() = CharacterLocationRemote(
    name = "character location name",
    url = "character location url"
)

@TestOnly
fun CharacterOriginRemote.Companion.mock() = CharacterOriginRemote(
    name = "character origin name",
    url = "character url name"
)

@TestOnly
fun CharactersResponse.Companion.mock() = CharactersResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    episode = emptyList(),
    gender = "character gender",
    image = "character image",
    characterLocationCached = CharacterLocationCached.mock(),
    name = "character name",
    characterOriginCached = CharacterOriginCached.mock(),
    species = "character species",
    status = "character status",
    type = "character type",
    url = "character url"

)

@TestOnly
fun CharacterLocationCached.Companion.mock() = CharacterLocationCached(
    locationName = "character location name",
    locationUrl = "character location url"
)

@TestOnly
fun CharacterOriginCached.Companion.mock() = CharacterOriginCached(
    originName = "character origin name",
    originUrl = "character origin url"
)