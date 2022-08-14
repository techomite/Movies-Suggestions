package com.andromite.moviessuggestions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andromite.moviessuggestions.databinding.ActivityMainBinding
import com.andromite.moviessuggestions.network.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.rvList.layoutManager = LinearLayoutManager(this)

//        viewModel.moviesList.observe(this) {
//            val adapter = it?.movies?.let { MoviesAdapter(it) }
//            binding.rvList.adapter = adapter
//        }

        CoroutineScope(Dispatchers.Main).launch {
            val response = ApiClient().apiClient.getMoviesList(1)
            val body = response.body()
            if (body?.status.equals("ok")) {
                val adapter = body?.data?.movies?.let { MoviesAdapter(it) }

                Log.e("asdfasdf","${body?.data}")
            } else if (body?.status.equals("error")) {

            }
        }

    }
}