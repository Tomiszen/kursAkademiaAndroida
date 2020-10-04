package com.tomisztomek.kursakademiaandroida.features.locations.all.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.api.model.LocationsResponse
import com.tomisztomek.kursakademiaandroida.core.base.BaseAdapter
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.location_item.view.*

class LocationAdapter(private val locationsViewModel: LocationsViewModel) :
    BaseAdapter<LocationDisplayable>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.location_item, parent, false)

        return LocationViewHolder(itemView, locationsViewModel)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val location = items[position]
        (holder as LocationViewHolder).bind(location)
    }

    class LocationViewHolder(itemView: View, locationsViewModel: LocationsViewModel) :
        RecyclerView.ViewHolder(itemView) {
        private var mLocationsViewModel: LocationsViewModel = locationsViewModel
        fun bind(location: LocationDisplayable) {
            with(itemView) {
                location_name.text = location.name
                location_dimension.text = location.dimension
                location_type.text = location.type
                setOnClickListener { mLocationsViewModel.onLocationClick(location) }
            }
        }
    }
}
