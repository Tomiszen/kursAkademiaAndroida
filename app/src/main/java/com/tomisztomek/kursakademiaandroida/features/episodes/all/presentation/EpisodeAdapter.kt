package com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.core.adapter.BindableAdapter
import com.tomisztomek.kursakademiaandroida.databinding.EpisodeItemBinding
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter : BindableAdapter<EpisodeDisplayable>,
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes by lazy { mutableListOf<EpisodeDisplayable>() }
    private var listener: ((EpisodeDisplayable) -> Unit)? = null

    override fun setItems(items: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) {
            this.episodes.clear()
        }
        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = EpisodeItemBinding.inflate(inflater, parent, false)

        return EpisodeViewHolder(binding)
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    inner class EpisodeViewHolder(private val binding: EpisodeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeDisplayable) {
            with(binding) {
                item = episode
                listener?.let { root.setOnClickListener { it(episode) } }
                binding.executePendingBindings()
            }
        }
    }
}
