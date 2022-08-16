package com.andromite.moviessuggestions.network.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("movie_count")
    val movieCount: Int? = null,
    @SerializedName("movies")
    val movies: List<Movy?>? = null,
    @SerializedName("page_number")
    val pageNumber: Int? = null
)