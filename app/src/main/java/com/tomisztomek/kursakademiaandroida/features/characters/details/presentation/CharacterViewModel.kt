package com.tomisztomek.kursakademiaandroida.features.characters.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tomisztomek.kursakademiaandroida.core.base.BaseViewModel
import com.tomisztomek.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterViewModel: BaseViewModel() {
    private val _character by lazy { MutableLiveData<CharacterDisplayable>() }
    val character: LiveData<CharacterDisplayable> by lazy { _character }

    fun onCharacterPassed(character: CharacterDisplayable) {
        _character.value = character
    }
}