package com.tomisztomek.kursakademiaandroida.features.characters.all.presentation

import android.view.View
import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.core.extenstion.viewBinding
import com.tomisztomek.kursakademiaandroida.databinding.FragmentCharacterBinding
import kotlinx.android.synthetic.main.fragment_character.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class CharacterFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val characterAdapter: CharacterAdapter by lifecycleScope.inject()

    override val viewModel: CharactersViewModel by lifecycleScope.viewModel(this)

    override fun initView() {
        super.initView()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
        character_progress_bar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        character_progress_bar.visibility = View.VISIBLE
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            characterAdapter.setCharacters(it)
        }
    }

    private fun initRecycler() {
        with(binding.characterList) {
            setHasFixedSize(true)
            adapter = characterAdapter
        }
        characterAdapter.setOnCharacterClickListener { viewModel.onCharacterClick(it) }
    }
}