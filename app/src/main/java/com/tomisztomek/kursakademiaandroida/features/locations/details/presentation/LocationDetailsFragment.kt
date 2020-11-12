package com.tomisztomek.kursakademiaandroida.features.locations.details.presentation

import android.os.Bundle
import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.BR
import com.tomisztomek.kursakademiaandroida.core.base.BaseFragment
import com.tomisztomek.kursakademiaandroida.databinding.FragmentLocationDetailsBinding
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import org.koin.androidx.scope.lifecycleScope
import org.koin.androidx.viewmodel.scope.viewModel

class LocationDetailsFragment : BaseFragment<LocationViewModel, FragmentLocationDetailsBinding>(
    BR.viewModel,
    R.layout.fragment_location_details
) {

    override val viewModel: LocationViewModel by lifecycleScope.viewModel(this)

    companion object {
        const val LOCATION_DETAILS_KEY = "locationDetailsKey"
    }

    override fun initView(it: FragmentLocationDetailsBinding) {
        super.initView(it)
        binding = FragmentLocationDetailsBinding.bind(requireView())
        binding?.let {
            it.lifecycleOwner = viewLifecycleOwner
            it.viewModel = viewModel
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let { viewModel.onLocationPassed(it) }
    }
}