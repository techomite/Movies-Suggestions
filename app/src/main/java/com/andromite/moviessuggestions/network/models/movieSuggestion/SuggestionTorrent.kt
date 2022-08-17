package com.andromite.moviessuggestions.network.models.movieSuggestion


import com.google.gson.annotations.SerializedName

data class SuggestionTorrent(
    @SerializedName("date_uploaded")
    val dateUploaded: String? = null,
    @SerializedName("date_uploaded_unix")
    val dateUploadedUnix: Int? = null,
    @SerializedName("hash")
    val hash: String? = null,
    @SerializedName("peers")
    val peers: Int? = null,
    @SerializedName("quality")
    val quality: String? = null,
    @SerializedName("seeds")
    val seeds: Int? = null,
    @SerializedName("size")
    val size: String? = null,
    @SerializedName("size_bytes")
    val sizeBytes: Long? = null,
    @SerializedName("url")
    val url: String? = null
)