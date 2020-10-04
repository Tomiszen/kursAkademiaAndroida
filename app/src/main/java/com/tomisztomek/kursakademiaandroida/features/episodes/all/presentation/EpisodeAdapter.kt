package com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseAdapter
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.episode_item.view.*

class EpisodeAdapter(private val episodesViewModel: EpisodesViewModel) :
    BaseAdapter<EpisodeDisplayable>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.episode_item, parent, false)

        return EpisodeViewHolder(itemView, episodesViewModel)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val episode = items[position]
        (holder as EpisodeViewHolder).bind(episode)
    }

    class EpisodeViewHolder(itemView: View, episodesViewModel: EpisodesViewModel) :
        RecyclerView.ViewHolder(itemView) {
        private var mEpisodesViewModel: EpisodesViewModel = episodesViewModel

        fun bind(episode: EpisodeDisplayable) {
            with(itemView) {
                episode_code.text = episode.code
                episode_title.text = episode.name
                episode_air_date.text = episode.airDate
                setOnClickListener { mEpisodesViewModel.onEpisodeClick(episode) }

            }
        }
    }
}
