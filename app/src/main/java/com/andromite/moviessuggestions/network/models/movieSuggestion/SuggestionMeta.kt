package com.andromite.moviessuggestions.network.models.movieSuggestion


import com.google.gson.annotations.SerializedName

data class SuggestionMeta(
    @SerializedName("api_version")
    val apiVersion: Int? = null,
    @SerializedName("execution_time")
    val executionTime: String? = null,
    @SerializedName("server_time")
    val serverTime: Int? = null,
    @SerializedName("server_timezone")
    val serverTimezone: String? = null
)