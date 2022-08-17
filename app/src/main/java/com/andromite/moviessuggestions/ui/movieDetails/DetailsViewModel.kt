package com.andromite.moviessuggestions.ui.movieDetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.moviessuggestions.network.ApiClient
import com.andromite.moviessuggestions.network.models.movieDetails.Movie
import com.andromite.moviessuggestions.network.models.movieList.MoviesListData
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    var movieDetails = MutableLiveData<Any>()
    var movieSuggestions = MutableLiveData<Any>()

    fun getMovieDetails(movieId : Int) {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMovieDetails(movieId)
            val body = response.body()
            if (body?.status.equals("ok")) {
                movieDetails.postValue(body?.data?.movie)
            } else if (body?.status.equals("error")) {
                movieDetails.postValue("error")
            }
        }
    }

    fun getMovieSuggestion(movieId : Int) {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMovieSuggestion(movieId)
            val body = response.body()
            if (body?.status.equals("ok")) {
                movieSuggestions.postValue(body?.data?.movies)
            } else if (body?.status.equals("error")) {
                movieDetails.postValue("error")
            }
        }
    }

}