package com.andromite.moviessuggestions.network

import com.andromite.moviessuggestions.network.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Apis {

    @GET("list_movies.json")
    suspend fun getMoviesList(@Query("page") page: Int? =1,
                              @Query("limit") limit: Int? =20) :Response<MoviesList>

}