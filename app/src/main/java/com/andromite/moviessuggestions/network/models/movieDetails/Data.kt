package com.andromite.moviessuggestions.network.models.movieDetails


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("movie")
    val movie: Movie? = null
)