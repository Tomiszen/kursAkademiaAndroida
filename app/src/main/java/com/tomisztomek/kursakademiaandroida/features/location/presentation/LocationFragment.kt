package com.tomisztomek.kursakademiaandroida.features.location.presentation

import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    override fun initView() {
        super.initView()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            //code to display locations
        }
    }
}