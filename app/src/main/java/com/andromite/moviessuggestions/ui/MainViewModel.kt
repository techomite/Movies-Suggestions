package com.andromite.moviessuggestions.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.moviessuggestions.network.ApiClient
import com.andromite.moviessuggestions.network.models.Data
import com.andromite.moviessuggestions.utils.Constants
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var moviesList =  MutableLiveData<Data>()

    fun getMoviesList(page: Int?){
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(page, Constants.pageLimit)
            val body = response.body()
            if (body?.status.equals("ok")) {
                moviesList.postValue(body?.data)
            } else if (body?.status.equals("error")) {

            }
        }
    }

}