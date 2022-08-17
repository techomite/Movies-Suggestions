package com.andromite.moviessuggestions.network.models.movieDetails


import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("character_name")
    val characterName: String? = null,
    @SerializedName("imdb_code")
    val imdbCode: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url_small_image")
    val urlSmallImage: String? = null
)