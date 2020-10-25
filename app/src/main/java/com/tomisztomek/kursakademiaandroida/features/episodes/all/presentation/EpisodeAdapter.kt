package com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.databinding.EpisodeItemBinding
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    private val episodes by lazy { mutableListOf<EpisodeDisplayable>() }
    private var listener: ((EpisodeDisplayable) -> Unit)? = null

    fun setEpisodes(episodes: List<EpisodeDisplayable>) {
        if (episodes.isNotEmpty()) {
            this.episodes.clear()
        }

        this.episodes.addAll(episodes)
        notifyDataSetChanged()
    }

    fun setOnEpisodeClickListener(listener: (EpisodeDisplayable) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.episode_item, parent, false)

        return EpisodeViewHolder(itemView)
    }

    override fun getItemCount(): Int = episodes.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode, listener)
    }

    class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = EpisodeItemBinding.bind(itemView)

        fun bind(
            episode: EpisodeDisplayable,
            listener: ((EpisodeDisplayable) -> Unit)?
        ) {
            with(binding) {
                episodeCode.text = episode.code
                episodeTitle.text = episode.name
                episodeAirDate.text = episode.airDate
                listener?.let { root.setOnClickListener { it(episode) } }
            }
        }
    }
}
