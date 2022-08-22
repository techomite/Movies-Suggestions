package com.andromite.moviessuggestions.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.moviessuggestions.network.ApiClient
import com.andromite.moviessuggestions.network.models.movieList.MoviesListData
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    val searchList = MutableLiveData<MoviesListData>()

    fun clearList(){
        val empty = MoviesListData()
        searchList.postValue(empty)
    }

    fun getSearchList(searchTerm : String){
        viewModelScope.launch {
            val response = ApiClient().apiClient.getSearchResultList(searchTerm)
            val body = response.body()
            if (body?.status.equals("ok")) {
                searchList.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

}