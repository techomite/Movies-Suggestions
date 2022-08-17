package com.andromite.moviessuggestions.network.models.movieDetails


import com.google.gson.annotations.SerializedName

data class DetailsResponse(
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("@meta")
    val meta: Meta? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null
)