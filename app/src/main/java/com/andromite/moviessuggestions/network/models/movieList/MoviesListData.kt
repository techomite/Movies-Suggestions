package com.andromite.moviessuggestions.network.models.movieList


import com.google.gson.annotations.SerializedName

data class MoviesListData(
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("movie_count")
    val movieCount: Int? = null,
    @SerializedName("movies")
    val movies: List<Movy?>? = null,
    @SerializedName("page_number")
    val pageNumber: Int? = null
)