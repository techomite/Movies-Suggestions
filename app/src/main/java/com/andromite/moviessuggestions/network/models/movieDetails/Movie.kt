package com.andromite.moviessuggestions.network.models.movieDetails


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("background_image")
    val backgroundImage: String? = null,
    @SerializedName("background_image_original")
    val backgroundImageOriginal: String? = null,
    @SerializedName("cast")
    val cast: List<Cast?>? = null,
    @SerializedName("date_uploaded")
    val dateUploaded: String? = null,
    @SerializedName("date_uploaded_unix")
    val dateUploadedUnix: Int? = null,
    @SerializedName("description_full")
    val descriptionFull: String? = null,
    @SerializedName("description_intro")
    val descriptionIntro: String? = null,
    @SerializedName("download_count")
    val downloadCount: Int? = null,
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
    @SerializedName("large_screenshot_image1")
    val largeScreenshotImage1: String? = null,
    @SerializedName("large_screenshot_image2")
    val largeScreenshotImage2: String? = null,
    @SerializedName("large_screenshot_image3")
    val largeScreenshotImage3: String? = null,
    @SerializedName("like_count")
    val likeCount: Int? = null,
    @SerializedName("medium_cover_image")
    val mediumCoverImage: String? = null,
    @Expose
    @SerializedName("medium_screenshot_image1")
    val mediumScreenshotImage1: String? = null,
    @SerializedName("medium_screenshot_image2")
    val mediumScreenshotImage2: String? = null,
    @SerializedName("medium_screenshot_image3")
    val mediumScreenshotImage3: String? = null,
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
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("title_english")
    val titleEnglish: String? = null,
    @SerializedName("title_long")
    val titleLong: String? = null,
    @SerializedName("torrents")
    val torrents: List<Torrent?>? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("year")
    val year: Int? = null,
    @SerializedName("yt_trailer_code")
    val ytTrailerCode: String? = null
)