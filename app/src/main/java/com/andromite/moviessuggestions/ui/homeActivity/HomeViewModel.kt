package com.andromite.moviessuggestions.ui.homeActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.moviessuggestions.network.ApiClient
import com.andromite.moviessuggestions.network.models.movieList.MoviesListData
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var trendingList = MutableLiveData<MoviesListData>()
    var latestList = MutableLiveData<MoviesListData>()
    var adventureList = MutableLiveData<MoviesListData>()
    var comedyList = MutableLiveData<MoviesListData>()
    var horrorList = MutableLiveData<MoviesListData>()

    fun getTrendingList() {
        viewModelScope.launch {

            val searchFilters: MutableMap<String, String> = HashMap()
            searchFilters["sort_by"] = "download_count"

            val response = ApiClient().apiClient.getCustomMoviesList(searchFilters)
            val body = response.body()
            if (body?.status.equals("ok")) {
                trendingList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun getLatestList() {
        viewModelScope.launch {

            val searchFilters: MutableMap<String, String> = HashMap()
            searchFilters["sort_by"] = "date_added"


            val response = ApiClient().apiClient.getCustomMoviesList(searchFilters)
            val body = response.body()
            if (body?.status.equals("ok")) {
                latestList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun getAdventureList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(genre = "adventure")
            val body = response.body()
            if (body?.status.equals("ok")) {
                adventureList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun getComedyList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(genre = "comedy")
            val body = response.body()
            if (body?.status.equals("ok")) {
                comedyList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun getHorrorList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(genre = "horror")
            val body = response.body()
            if (body?.status.equals("ok")) {
                horrorList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

}