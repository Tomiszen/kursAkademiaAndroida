package com.tomisztomek.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.databinding.LocationItemBinding
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private val locations by lazy { mutableListOf<LocationDisplayable>() }
    private var listener: ((LocationDisplayable) -> Unit)? = null

    fun setLocations(locations: List<LocationDisplayable>) {
        if (locations.isNotEmpty()) {
            this.locations.clear()
        }

        this.locations.addAll(locations)
        notifyDataSetChanged()
    }

    fun setOnLocationClickListener(listener: (LocationDisplayable) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.location_item, parent, false)

        return LocationViewHolder(itemView)
    }

    override fun getItemCount(): Int = locations.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = locations[position]
        holder.bind(location, listener)
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = LocationItemBinding.bind(itemView)

        fun bind(
            location: LocationDisplayable,
            listener: ((LocationDisplayable) -> Unit)?
        ) {
            with(binding) {
                locationName.text = location.name
                locationDimension.text = location.dimension
                locationType.text = location.type
                listener?.let { root.setOnClickListener { it(location) } }
            }
        }
    }
}
