package com.andromite.moviessuggestions.network.models.movieSuggestion


import com.google.gson.annotations.SerializedName

data class SuggestionsData(
    @SerializedName("movie_count")
    val movieCount: Int? = null,
    @SerializedName("movies")
    val movies: List<SuggestionMovy?>? = null
)