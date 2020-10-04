package com.tomisztomek.kursakademiaandroida.features.characters.all.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_character.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharactersViewModel>(R.layout.fragment_character) {

    override val viewModel: CharactersViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initView() {
        super.initView()
        character_list.layoutManager = layoutManager
        character_list.adapter = adapter
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
            adapter.setItems(it)
        }
    }
}