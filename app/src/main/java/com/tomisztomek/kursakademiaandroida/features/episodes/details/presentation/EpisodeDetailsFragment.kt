package com.tomisztomek.kursakademiaandroida.features.episodes.details.presentation

import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
class EpisodeDetailsFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}