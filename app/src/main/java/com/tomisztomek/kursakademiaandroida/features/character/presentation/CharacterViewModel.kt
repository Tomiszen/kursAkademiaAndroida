package com.tomisztomek.kursakademiaandroida.features.character.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.tomisztomek.kursakademiaandroida.core.base.BaseViewModel
import com.tomisztomek.kursakademiaandroida.core.exception.ErrorMapper
import com.tomisztomek.kursakademiaandroida.features.character.domain.GetCharactersUseCase
import com.tomisztomek.kursakademiaandroida.features.character.domain.model.Character
import com.tomisztomek.kursakademiaandroida.features.character.presentation.model.CharacterDisplayable

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters -> characters.map { CharacterDisplayable(it) } }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}