package com.tomisztomek.kursakademiaandroida.features.characters.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.core.extenstion.viewBinding
import com.tomisztomek.kursakademiaandroida.databinding.FragmentCharacterDetailsBinding
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterViewModel>(R.layout.fragment_character_details) {

    private val binding by viewBinding(FragmentCharacterDetailsBinding::bind)
    override val viewModel: CharacterViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacter()
    }

    private fun observeCharacter() {
        viewModel.character.observe(this) { showCharacter(it) }
    }

    private fun showCharacter(character: CharacterDisplayable) {
        with(binding) {

            characterName.text = character.name
            characterGender.text = character.gender
            characterSpecies.text = character.species
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<CharacterDisplayable>(CharacterDetailsFragment.CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterPassed(it) }
    }
}