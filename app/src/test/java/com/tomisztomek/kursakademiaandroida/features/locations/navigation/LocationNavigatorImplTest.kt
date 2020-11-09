package com.tomisztomek.kursakademiaandroida.features.locations.navigation

import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.navigation.FragmentNavigator
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.tomisztomek.kursakademiaandroida.features.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationNavigatorImplTest {

    @Test
    fun `WHEN openLocationDetailsScreen is called THAN invoke navigateTo method with appropriate action and location model as argument`() {

        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val location = LocationDisplayable.mock()
        val slot = slot<Pair<String, LocationDisplayable>>()

        //when
        locationNavigator.openLocationDetailsScreen(location)

        //than
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigation_from_location_screen_to_location_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe location
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator`() {

        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)

        //when
        locationNavigator.goBack()

        //than
        verify {
            fragmentNavigator.goBack()
        }
    }
}