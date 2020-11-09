package com.tomisztomek.kursakademiaandroida.features.episodes.navigation

import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.navigation.FragmentNavigator
import com.tomisztomek.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.tomisztomek.kursakademiaandroida.features.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeNavigatorImplTest {

    @Test
    fun `WHEN openEpisodeDetailsScreen is called THAN invoke navigateTo method with appropriate action and episode model as argument`() {

        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)
        val episode = EpisodeDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        //when
        episodeNavigator.openEpisodeDetailsScreen(episode)

        //than
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigation_from_episode_screen_to_episode_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe episode
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator`() {

        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val episodeNavigator: EpisodeNavigator = EpisodeNavigatorImpl(fragmentNavigator)

        //when
        episodeNavigator.goBack()

        //than
        verify {
            fragmentNavigator.goBack()
        }
    }
}