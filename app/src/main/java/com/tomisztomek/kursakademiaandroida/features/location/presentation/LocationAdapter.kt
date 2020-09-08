package com.tomisztomek.kursakademiaandroida.features.location.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseAdapter
import com.tomisztomek.kursakademiaandroida.features.location.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.location_item.view.*

class LocationAdapter : BaseAdapter<LocationDisplayable>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.location_item, parent, false)

        return LocationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val location = items[position]
        (holder as LocationViewHolder).bind(location)
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(location: LocationDisplayable) {
            with(itemView) {
                location_name.text = location.name
                location_dimension.text = location.dimension
                location_type.text = location.type
            }
        }
    }
}
