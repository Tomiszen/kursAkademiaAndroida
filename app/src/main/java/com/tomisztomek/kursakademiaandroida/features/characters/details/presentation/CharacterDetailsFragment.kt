package com.tomisztomek.kursakademiaandroida.features.characters.details.presentation

import android.os.Bundle
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.BR
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.databinding.FragmentCharacterDetailsBinding
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class CharacterDetailsFragment : BaseFragment<CharacterViewModel, FragmentCharacterDetailsBinding>(
        BR.viewModel,
        R.layout.fragment_character_details
    ) {

    override val viewModel: CharacterViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initView(it: FragmentCharacterDetailsBinding) {
        super.initView(it)
        binding = FragmentCharacterDetailsBinding.bind(requireView())
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
            ?.getParcelable<CharacterDisplayable>(CharacterDetailsFragment.CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterPassed(it) }
    }
}