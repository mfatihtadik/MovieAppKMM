package com.example.movieappkmm.detail

data class DetailScreenState(
    var loading : Boolean = false,
    var movie : com.example.movieappkmm.domain.model.Movie? = null,
    var errorMessage : String? = null
)