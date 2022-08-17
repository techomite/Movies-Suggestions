package com.andromite.moviessuggestions.network.models.movieList


import com.google.gson.annotations.SerializedName

data class MoviesListMeta(
    @SerializedName("api_version")
    val apiVersion: Int? = null,
    @SerializedName("execution_time")
    val executionTime: String? = null,
    @SerializedName("server_time")
    val serverTime: Int? = null,
    @SerializedName("server_timezone")
    val serverTimezone: String? = null
)