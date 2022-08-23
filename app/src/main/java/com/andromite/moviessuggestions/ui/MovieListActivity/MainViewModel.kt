package com.andromite.moviessuggestions.ui.MovieListActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andromite.moviessuggestions.network.ApiClient
import com.andromite.moviessuggestions.network.models.movieList.MoviesListData
import com.andromite.moviessuggestions.utils.Constants
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var moviesListFirstTime =  MutableLiveData<MoviesListData>()
    var moviesListSecondTime =  MutableLiveData<MoviesListData>()

    fun getMoviesList(page: Int?){
        viewModelScope.launch {
            val response = ApiClient().apiClient.getMoviesList(page, Constants.pageLimit)
            val body = response.body()
            if (body?.status.equals("ok")) {
                if (page == 1)
                moviesListFirstTime.postValue(body?.moviesListData)
                else
                    moviesListSecondTime.postValue(body?.moviesListData)
            } else if (body?.status.equals("error")) {

            }
        }
    }

}