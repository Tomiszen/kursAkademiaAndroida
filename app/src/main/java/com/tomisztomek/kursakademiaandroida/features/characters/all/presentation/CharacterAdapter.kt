package com.tomisztomek.kursakademiaandroida.features.characters.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.core.adapter.BindableAdapter
import com.tomisztomek.kursakademiaandroida.databinding.CharacterItemBinding
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterAdapter : BindableAdapter<CharacterDisplayable>,
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private val characters by lazy { mutableListOf<CharacterDisplayable>() }
    private var listener: ((CharacterDisplayable) -> Unit)? = null

    override fun setItems(items: List<CharacterDisplayable>) {
        if (characters.isNotEmpty()) {
            this.characters.clear()
        }
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CharacterItemBinding.inflate(inflater, parent, false)

        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    inner class CharacterViewHolder(private val binding: CharacterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDisplayable) {
            with(binding) {
                item = character
                listener?.let { root.setOnClickListener { it(character) } }
                binding.executePendingBindings()
            }
        }
    }
}
