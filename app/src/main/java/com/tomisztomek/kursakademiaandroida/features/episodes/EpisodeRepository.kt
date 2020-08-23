package com.tomisztomek.kursakademiaandroida.features.episodes

import com.tomisztomek.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {

    suspend fun getEpisodes(): List<Episode>
}