package com.tomisztomek.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseAdapter
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.character_item.view.*

class CharacterAdapter(private val charactersViewModel: CharactersViewModel) :
    BaseAdapter<CharacterDisplayable>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_item, parent, false)

        return CharacterViewHolder(itemView, charactersViewModel)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val character = items[position]
        (holder as CharacterViewHolder).bind(character)
    }

    class CharacterViewHolder(itemView: View, charactersViewModel: CharactersViewModel) :
        RecyclerView.ViewHolder(itemView) {
        private var mCharactersViewModel: CharactersViewModel = charactersViewModel

        fun bind(character: CharacterDisplayable) {
            with(itemView) {
                character_name.text = character.name
                character_gender.text = character.gender
                character_type.text = character.type
                setOnClickListener { mCharactersViewModel.onCharacterClick(character) }

            }
        }
    }
}
