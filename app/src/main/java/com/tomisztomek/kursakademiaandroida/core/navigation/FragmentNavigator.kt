package com.tomisztomek.kursakademiaandroida.core.navigation

import androidx.annotation.IdRes

interface FragmentNavigator {

    fun <T> navigateTo(
        @IdRes destinationID: Int,
        param: Pair<String, T>? = null,
        fragmentTransition: FragmentTransition? = null
    )

    fun  navigateTo(
        @IdRes destinationID: Int,
        fragmentTransition: FragmentTransition? = null
    )

    fun goBack(
        @IdRes destinationId: Int? = null,
        inclusive: Boolean = false
    )

    fun clearHistory()
}