package com.tomisztomek.kursakademiaandroida.features.location.presentation

import android.view.View
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()
    private val adapter: LocationAdapter by inject()
    private val layoutManager: RecyclerView.LayoutManager by inject()

    override fun initView() {
        super.initView()
        location_list.layoutManager = layoutManager
        location_list.adapter = adapter
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
            adapter.setItems(it)
        }
    }
}