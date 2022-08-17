package com.andromite.moviessuggestions.network.models.movieList


import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("data")
    val moviesListData: MoviesListData? = null,
    @SerializedName("@meta")
    val meta: MoviesListMeta? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null
)