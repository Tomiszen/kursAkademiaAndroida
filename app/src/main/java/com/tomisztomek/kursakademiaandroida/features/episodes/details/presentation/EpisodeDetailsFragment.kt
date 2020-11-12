package com.tomisztomek.kursakademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.BR
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.databinding.FragmentEpisodeDetailsBinding
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class EpisodeDetailsFragment : BaseFragment<EpisodeViewModel, FragmentEpisodeDetailsBinding>(
    BR.viewModel,
    R.layout.fragment_episode_details
) {

    override val viewModel: EpisodeViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun initView(it: FragmentEpisodeDetailsBinding) {
        super.initView(it)
        binding = FragmentEpisodeDetailsBinding.bind(requireView())
        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let { viewModel.onEpisodePassed(it) }
    }
}