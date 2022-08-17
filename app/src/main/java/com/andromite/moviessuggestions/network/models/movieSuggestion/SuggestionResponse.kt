package com.andromite.moviessuggestions.network.models.movieSuggestion


import com.google.gson.annotations.SerializedName

data class SuggestionResponse(
    @SerializedName("data")
    val `data`: SuggestionsData? = null,
    @SerializedName("@meta")
    val meta: SuggestionMeta? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null
)