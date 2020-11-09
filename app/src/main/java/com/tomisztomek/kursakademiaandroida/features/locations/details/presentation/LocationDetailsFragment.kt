package com.tomisztomek.kursakademiaandroida.features.locations.details.presentation

import android.os.Bundle
import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.core.extenstion.viewBinding
import com.tomisztomek.kursakademiaandroida.databinding.FragmentLocationDetailsBinding
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationViewModel>(R.layout.fragment_location_details) {

    private val binding by viewBinding(FragmentLocationDetailsBinding::bind)
    override val viewModel: LocationViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        observeLocation()
    }

    private fun observeLocation() {
        viewModel.location.observe(this) { showLocation(it) }
    }

    private fun showLocation(location: LocationDisplayable) {
        with(binding) {

            locationName.text = location.name
            locationDimension.text = location.dimension
            locationType.text = location.type
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let { viewModel.onLocationPassed(it) }
    }
}