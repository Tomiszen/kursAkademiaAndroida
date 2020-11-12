package com.tomisztomek.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.core.adapter.BindableAdapter
import com.tomisztomek.kursakademiaandroida.databinding.LocationItemBinding
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationAdapter : BindableAdapter<LocationDisplayable>,
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val locations by lazy { mutableListOf<LocationDisplayable>() }
    private var listener: ((LocationDisplayable) -> Unit)? = null

    override fun setItems(items: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) {
            this.locations.clear()
        }
        this.locations.addAll(locations)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LocationItemBinding.inflate(inflater, parent, false)

        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int = locations.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location)
    }

    inner class LocationViewHolder(private val binding: LocationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(location: LocationDisplayable) {
            with(binding) {
                item = location
                listener?.let { root.setOnClickListener { it(location) } }
                binding.executePendingBindings()
            }
        }
    }
}
