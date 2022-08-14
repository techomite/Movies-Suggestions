package com.andromite.moviessuggestions.network.models


import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("@meta")
    val meta: Meta,
    @SerializedName("status")
    val status: String,
    @SerializedName("status_message")
    val statusMessage: String
)