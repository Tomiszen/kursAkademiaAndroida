package com.tomisztomek.kursakademiaandroida.features.character.presentation

import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    override fun initView() {
        super.initView()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            //code to display characters
        }
    }
}