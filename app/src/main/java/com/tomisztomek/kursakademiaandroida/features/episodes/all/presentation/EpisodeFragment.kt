package com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomisztomek.kursakademiaandroida.BR
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.databinding.FragmentEpisodeBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope

class EpisodeFragment : BaseFragment<EpisodesViewModel, FragmentEpisodeBinding>(
    BR.viewModel,
    R.layout.fragment_episode
) {

    private val episodeAdapter: EpisodeAdapter by lifecycleScope.inject()
    override val viewModel: EpisodesViewModel by lifecycleScope.inject()
    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()

    override fun initView(binding: FragmentEpisodeBinding) {
        super.initView(binding)
        initRecycler(binding)
    }

    override fun onDestroyView() {
        binding?.episodeList?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

    private fun initRecycler(binding: FragmentEpisodeBinding) {
        with(binding.episodeList) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = episodeAdapter
        }
    }
}