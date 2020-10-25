package com.tomisztomek.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.databinding.CharacterItemBinding
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy {mutableListOf<CharacterDisplayable>() }
    private var listener: ((CharacterDisplayable) -> Unit)? = null

    fun setCharacters(characters: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }

        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    fun setOnCharacterClickListener(listener: (CharacterDisplayable) -> Unit) {
        this.listener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.CharacterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.character_item, parent, false)

        return CharacterAdapter.CharacterViewHolder(itemView)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character, listener)
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CharacterItemBinding.bind(itemView)

        fun bind(
            character: CharacterDisplayable,
            listener: ((CharacterDisplayable) -> Unit)?
        ) {
            with(binding) {
                characterName.text = character.name
                characterGender.text = character.gender
                characterSpecies.text = character.species
                listener?.let {root.setOnClickListener{ it(character)} }
            }
        }
    }
}
