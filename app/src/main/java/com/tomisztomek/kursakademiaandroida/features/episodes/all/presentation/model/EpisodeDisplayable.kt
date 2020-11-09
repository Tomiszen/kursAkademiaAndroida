package com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model

import android.os.Parcelable
import com.tomisztomek.kursakademiaandroida.features.episodes.domain.model.Episode
import kotlinx.android.parcel.Parcelize

@Parcelize
class EpisodeDisplayable(
    val airDate: String,
    val characters: List<String>,
    val code: String,
    val id: Int,
    val name: String,
    val url: String
): Parcelable {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )

    companion object
}