package com.tomisztomek.kursakademiaandroida.features.episodes.domain

import com.tomisztomek.kursakademiaandroida.core.base.UseCase
import com.tomisztomek.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}