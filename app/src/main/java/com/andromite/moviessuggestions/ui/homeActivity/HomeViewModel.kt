package com.andromite.moviessuggestions.ui.homeActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.moviessuggestions.network.ApiClient
import com.andromite.moviessuggestions.network.models.movieList.MoviesListData
import com.andromite.moviessuggestions.utils.Constants
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var trendingList = MutableLiveData<MoviesListData>()
    var latestList = MutableLiveData<MoviesListData>()

    var list3d = MutableLiveData<MoviesListData>()
    var actionList = MutableLiveData<MoviesListData>()
    var scifiList = MutableLiveData<MoviesListData>()
    var comedyList = MutableLiveData<MoviesListData>()
    var horrorList = MutableLiveData<MoviesListData>()

    fun getTrendingList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList()
            val body = response.body()
            if (body?.status.equals("ok")) {
                trendingList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun getLatestList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList()
            val body = response.body()
            if (body?.status.equals("ok")) {
                latestList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun get3DList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(quality = "3D")
            val body = response.body()
            if (body?.status.equals("ok")) {
                list3d.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun getActionList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(genre = "action")
            val body = response.body()
            if (body?.status.equals("ok")) {
                actionList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

    fun getScifiList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(genre = "sci-fi")
            val body = response.body()
            if (body?.status.equals("ok")) {
                scifiList.postValue(body?.moviesListData)
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