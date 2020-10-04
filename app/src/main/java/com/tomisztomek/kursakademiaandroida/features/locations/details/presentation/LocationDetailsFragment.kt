package com.tomisztomek.kursakademiaandroida.features.locations.details.presentation

import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
class LocationDetailsFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location_details) {

    override val viewModel: LocationViewModel by viewModel()

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }
}