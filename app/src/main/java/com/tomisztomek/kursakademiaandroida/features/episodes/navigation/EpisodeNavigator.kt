package com.tomisztomek.kursakademiaandroida.features.episodes.navigation

import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}