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

    fun getTrendingList() {
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(Constants.pageLimit)
            val body = response.body()
            if (body?.status.equals("ok")) {
                trendingList.postValue(body?.moviesListData)
                latestList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

}