package com.tomisztomek.kursakademiaandroida.core.api.model

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("result") val results: List<CharacterRemote>
) {
    companion object
}