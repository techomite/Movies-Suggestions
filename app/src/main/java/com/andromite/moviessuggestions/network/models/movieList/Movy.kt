package com.andromite.moviessuggestions.network.models.movieList


import com.google.gson.annotations.SerializedName

data class Movy(
    @SerializedName("background_image")
    val backgroundImage: String? = null,
    @SerializedName("background_image_original")
    val backgroundImageOriginal: String? = null,
    @SerializedName("date_uploaded")
    val dateUploaded: String? = null,
    @SerializedName("date_uploaded_unix")
    val dateUploadedUnix: Int? = null,
    @SerializedName("description_full")
    val descriptionFull: String? = null,
    @SerializedName("genres")
    val genres: List<String?>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("imdb_code")
    val imdbCode: String? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("large_cover_image")
    val largeCoverImage: String? = null,
    @SerializedName("medium_cover_image")
    val mediumCoverImage: String? = null,
    @SerializedName("mpa_rating")
    val mpaRating: String? = null,
    @SerializedName("rating")
    val rating: Double? = null,
    @SerializedName("runtime")
    val runtime: Int? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("small_cover_image")
    val smallCoverImage: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("summary")
    val summary: String? = null,
    @SerializedName("synopsis")
    val synopsis: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("title_english")
    val titleEnglish: String? = null,
    @SerializedName("title_long")
    val titleLong: String? = null,
    @SerializedName("torrents")
    val torrents: List<MoviesListTorrent?>? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("year")
    val year: Int? = null,
    @SerializedName("yt_trailer_code")
    val ytTrailerCode: String? = null
)