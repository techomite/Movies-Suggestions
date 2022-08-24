package com.andromite.moviessuggestions.network

import com.andromite.moviessuggestions.network.models.movieDetails.DetailsResponse
import com.andromite.moviessuggestions.network.models.movieList.MoviesList
import com.andromite.moviessuggestions.network.models.movieSuggestion.SuggestionResponse
import com.andromite.moviessuggestions.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET("list_movies.json")
    suspend fun getMoviesList(
        @Query("page") page: Int? = 1,
        @Query("limit") limit: Int? = Constants.pageLimit,
        @Query("genre") genre: String = "action",
        @Query("sort_by") sort: String = "date_added",
        @Query("order_by") order_by: String = "asc",
        @Query("quality") quality: String = "All"
    ): Response<MoviesList>

    @GET("list_movies.json")
    suspend fun getSearchResultList(
        @Query("query_term") searchTerm: String,
        @Query("sort_by") sortBy: String = "rating"
    ): Response<MoviesList>

    @GET("movie_details.json")
    suspend fun getMovieDetails(
        @Query("movie_id") movieId: Int,
        @Query("with_images") withImages: String = "true",
        @Query("with_cast") withCast: String = "true"
    ): Response<DetailsResponse>

    @GET("movie_suggestions.json")
    suspend fun getMovieSuggestion(@Query("movie_id") movieId: Int): Response<SuggestionResponse>

}