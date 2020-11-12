package com.tomisztomek.kursakademiaandroida.features.locations.all.presentation

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomisztomek.kursakademiaandroida.BR
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.databinding.FragmentLocationBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.scope.lifecycleScope

class LocationFragment : BaseFragment<LocationsViewModel, FragmentLocationBinding>(
    BR.viewModel,
    R.layout.fragment_location
) {

    private val locationAdapter: LocationAdapter by lifecycleScope.inject()
    override val viewModel: LocationsViewModel by lifecycleScope.inject()
    private val linearLayoutManager: LinearLayoutManager by inject()
    private val divider: DividerItemDecoration by inject()

    override fun initView(binding: FragmentLocationBinding) {
        super.initView(binding)
        initRecycler(binding)
    }

    override fun onDestroyView() {
        binding?.locationList?.let {
            it.layoutManager = null
            it.adapter = null
        }
        super.onDestroyView()
    }

    private fun initRecycler(binding: FragmentLocationBinding) {
        with(binding.locationList) {
            layoutManager = linearLayoutManager
            addItemDecoration(divider)
            setHasFixedSize(true)
            adapter = locationAdapter
        }
    }
}