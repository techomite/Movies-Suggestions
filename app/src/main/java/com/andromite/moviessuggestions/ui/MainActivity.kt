package com.andromite.moviessuggestions.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andromite.moviessuggestions.databinding.ActivityMainBinding


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

        viewModel.moviesList.observe(this) {
            val adapter = it?.movies?.let { MoviesAdapter(it, this@MainActivity) }
            binding.rvList.adapter = adapter
        }

        viewModel.getMoviesList(null)

    }
}