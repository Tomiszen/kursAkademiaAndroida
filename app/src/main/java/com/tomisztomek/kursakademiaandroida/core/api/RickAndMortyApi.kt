package com.tomisztomek.kursakademiaandroida.core.api

import com.tomisztomek.kursakademiaandroida.core.api.model.CharactersResponse
import com.tomisztomek.kursakademiaandroida.core.api.model.EpisodesResponse
import com.tomisztomek.kursakademiaandroida.core.api.model.LocationsResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("location")
    suspend fun getLocations(): LocationsResponse

    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}