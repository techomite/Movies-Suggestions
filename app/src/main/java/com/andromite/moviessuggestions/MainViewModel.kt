package com.andromite.moviessuggestions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.moviessuggestions.network.ApiClient
import com.andromite.moviessuggestions.network.models.Data
import com.andromite.moviessuggestions.network.models.MoviesList
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var moviesList : MutableLiveData<Data>? = null

    fun getMoviesList(){
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(1)
            val body = response.body()
            if (body?.status.equals("ok")) {
                moviesList?.value = body?.data
            } else if (body?.status.equals("error")) {

            }
        }
    }

}