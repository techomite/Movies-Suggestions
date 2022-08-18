package com.andromite.moviessuggestions.network

import com.andromite.moviessuggestions.network.models.movieDetails.DetailsResponse
import com.andromite.moviessuggestions.network.models.movieList.MoviesList
import com.andromite.moviessuggestions.network.models.movieSuggestion.SuggestionResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET("list_movies.json")
    suspend fun getMoviesList(@Query("page") page: Int? =1,
                              @Query("limit") limit: Int? =20,
                                @Query("genre") genre : String = "action",
                                @Query("sort_by") sort : String = "like_count") :Response<MoviesList>

    @GET("movie_details.json")
    suspend fun getMovieDetails(@Query("movie_id") movieId : Int) :Response<DetailsResponse>

    @GET("movie_suggestions.json")
    suspend fun getMovieSuggestion(@Query("movie_id") movieId : Int) :Response<SuggestionResponse>

}