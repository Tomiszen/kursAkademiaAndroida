package com.tomisztomek.kursakademiaandroida.features.locations.navigation

import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.navigation.FragmentNavigator
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.tomisztomek.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment

class LocationNavigatorImpl(private val fragmentNavigator: FragmentNavigator): LocationNavigator {

    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigation_from_location_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}