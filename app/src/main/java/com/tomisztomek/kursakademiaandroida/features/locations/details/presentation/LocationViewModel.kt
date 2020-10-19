package com.tomisztomek.kursakademiaandroida.features.locations.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tomisztomek.kursakademiaandroida.core.base.BaseViewModel
import com.tomisztomek.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

class LocationViewModel: BaseViewModel() {

    private val _location by lazy { MutableLiveData<LocationDisplayable>() }
    val location: LiveData<LocationDisplayable> by lazy { _location }

    fun onLocationPassed(character: LocationDisplayable) {
        _location.value = character
    }
}