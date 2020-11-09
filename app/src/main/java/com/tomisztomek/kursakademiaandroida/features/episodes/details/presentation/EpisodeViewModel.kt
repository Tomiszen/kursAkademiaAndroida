package com.tomisztomek.kursakademiaandroida.features.episodes.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tomisztomek.kursakademiaandroida.core.base.BaseViewModel
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.tomisztomek.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeViewModel: BaseViewModel() {

    private val _episode by lazy {MutableLiveData<EpisodeDisplayable>()}
    val episode: LiveData<EpisodeDisplayable> by lazy { _episode}

    fun onEpisodePassed(episode: EpisodeDisplayable) {
        _episode.value = episode
    }
}