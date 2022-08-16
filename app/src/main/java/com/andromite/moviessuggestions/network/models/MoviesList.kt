package com.andromite.moviessuggestions.network.models


import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("data")
    val `data`: Data? = null,
    @SerializedName("@meta")
    val meta: Meta? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null
)