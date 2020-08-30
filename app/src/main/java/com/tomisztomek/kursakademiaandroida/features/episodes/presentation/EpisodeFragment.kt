package com.tomisztomek.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

    override fun initView() {
        super.initView()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            //code to display episodes
        }
    }
}