package com.tomisztomek.kursakademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.core.extenstion.viewBinding
import com.tomisztomek.kursakademiaandroida.databinding.FragmentEpisodeDetailsBinding
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.android.ext.android.bind
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.scope.viewModel

class EpisodeDetailsFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode_details) {

    private val binding by viewBinding(FragmentEpisodeDetailsBinding::bind)
    override val viewModel: EpisodeViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisode()
    }

    private fun observeEpisode() {
        viewModel.episode.observe(this) { showEpisode(it)}
    }

    private fun showEpisode(episode: EpisodeDisplayable) {
        with(binding) {

            episodeCode.text = episode.code
            episodeTitle.text = episode.name
            episodeAirDate.text = episode.airDate
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let { viewModel.onEpisodePassed(it)}
    }
}