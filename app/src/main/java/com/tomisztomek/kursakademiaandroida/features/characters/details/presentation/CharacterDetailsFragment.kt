package com.tomisztomek.kursakademiaandroida.features.characters.details.presentation

import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
class CharacterDetailsFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character_details) {

    override val viewModel: CharacterViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }
}