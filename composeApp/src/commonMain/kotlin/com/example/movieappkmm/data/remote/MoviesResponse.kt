package com.example.movieappkmm.data.remote

import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesResponse(
    val results : List<MovieRemote>
)