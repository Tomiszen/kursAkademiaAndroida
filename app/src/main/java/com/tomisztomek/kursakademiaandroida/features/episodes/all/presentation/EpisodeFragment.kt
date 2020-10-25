package com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation

import android.view.View
import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.core.extenstion.viewBinding
import com.tomisztomek.kursakademiaandroida.databinding.FragmentEpisodeBinding
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class EpisodeFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    private val binding by viewBinding(FragmentEpisodeBinding::bind)
    private val episodeAdapter: EpisodeAdapter by lifecycleScope.inject()

    override val viewModel: EpisodesViewModel by lifecycleScope.inject()

    override fun initView() {
        super.initView()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        episode_progress_bar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        episode_progress_bar.visibility = View.VISIBLE
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            episodeAdapter.setEpisodes(it)
        }
    }

    private fun initRecycler() {
        with(binding.episodeList) {
            setHasFixedSize(true)
            adapter = episodeAdapter
        }
        episodeAdapter.setOnEpisodeClickListener { viewModel.onEpisodeClick(it) }

    }

}