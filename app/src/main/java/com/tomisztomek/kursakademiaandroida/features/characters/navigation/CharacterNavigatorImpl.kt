package com.tomisztomek.kursakademiaandroida.features.characters.navigation

import com.tomisztomek.kursakademiaandroida.R
import com.tomisztomek.kursakademiaandroida.core.navigation.FragmentNavigator
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.tomisztomek.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment

class CharacterNavigatorImpl(private val fragmentNavigator: FragmentNavigator): CharacterNavigator {

    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigation_from_character_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}