package com.tomisztomek.kursakademiaandroida.features.characters.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.BR
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.databinding.FragmentCharacterBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope

class CharacterFragment : BaseFragment<CharactersViewModel, FragmentCharacterBinding>(
    BR.viewModel,
    R.layout.fragment_character
) {

    private val characterAdapter: CharacterAdapter by lifecycleScope.inject()
    override val viewModel: CharactersViewModel by lifecycleScope.inject()
    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()

    override fun initView(binding: FragmentCharacterBinding) {
        super.initView(binding)
        initRecycler(binding)
    }

    override fun onDestroyView() {
        binding?.characterList?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

    private fun initRecycler(binding: FragmentCharacterBinding) {
        with(binding.characterList) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = characterAdapter
        }
    }
}