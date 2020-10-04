package com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()
    private val adapter: EpisodeAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initView() {
        super.initView()
        episode_list.layoutManager = layoutManager
        episode_list.adapter = adapter
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

    override fun onDestroyView() {
        super.onDestroyView()
        episode_list.layoutManager=null
        episode_list.adapter=null
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            adapter.setItems(it)
        }
    }



}