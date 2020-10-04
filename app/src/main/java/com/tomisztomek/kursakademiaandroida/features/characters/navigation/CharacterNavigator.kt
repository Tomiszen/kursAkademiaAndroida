package com.tomisztomek.kursakademiaandroida.features.characters.navigation

import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}