package com.andromite.moviessuggestions.network.models.movieDetails


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("api_version")
    val apiVersion: Int? = null,
    @SerializedName("execution_time")
    val executionTime: String? = null,
    @SerializedName("server_time")
    val serverTime: Int? = null,
    @SerializedName("server_timezone")
    val serverTimezone: String? = null
)