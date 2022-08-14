package com.andromite.moviessuggestions.network.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("movie_count")
    val movieCount: Int,
    @SerializedName("movies")
    val movies: List<Movy>,
    @SerializedName("page_number")
    val pageNumber: Int
)