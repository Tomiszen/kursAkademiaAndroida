package com.tomisztomek.kursakademiaandroida.features.episodes.domain

import com.tomisztomek.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {

    suspend fun getEpisodes(): List<Episode>
}