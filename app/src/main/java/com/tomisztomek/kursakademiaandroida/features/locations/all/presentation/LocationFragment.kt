package com.tomisztomek.kursakademiaandroida.features.locations.all.presentation

import android.view.View
import androidx.lifecycle.observe
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.core.extenstion.viewBinding
import com.tomisztomek.kursakademiaandroida.databinding.FragmentLocationBinding
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class LocationFragment : BaseFragment<LocationsViewModel>(R.layout.fragment_location) {

    private val binding by viewBinding(FragmentLocationBinding::bind)
    private val locationAdapter: LocationAdapter by lifecycleScope.inject()

    override val viewModel: LocationsViewModel by lifecycleScope.viewModel(this)

    override fun initView() {
        super.initView()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
        location_progress_bar.visibility = View.GONE
    }

    override fun onPendingState() {
        super.onPendingState()
        location_progress_bar.visibility = View.VISIBLE
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            locationAdapter.setLocations(it)
        }
    }

    private fun initRecycler() {
        with(binding.locationList) {
            setHasFixedSize(true)
            adapter = locationAdapter
        }
        locationAdapter.setOnLocationClickListener { viewModel.onLocationClick(it) }
    }

}