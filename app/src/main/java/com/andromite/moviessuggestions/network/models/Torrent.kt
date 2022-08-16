package com.andromite.moviessuggestions.network.models


import com.google.gson.annotations.SerializedName

data class Torrent(
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
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("url")
    val url: String? = null
)