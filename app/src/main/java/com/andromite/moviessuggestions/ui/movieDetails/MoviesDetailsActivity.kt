package com.andromite.moviessuggestions.ui.movieDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.databinding.ActivityMainBinding
import com.andromite.moviessuggestions.databinding.ActivitySearchBinding
import com.andromite.moviessuggestions.network.models.movieDetails.Movie
import com.andromite.moviessuggestions.network.models.movieSuggestion.SuggestionMovy

class MoviesDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivitySearchBinding
    lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]

        val movieId = intent.getIntExtra("movieId",0)

        viewModel.getMovieDetails(movieId)
        viewModel.getMovieSuggestion(movieId)
        observeDataRequest()
    }

    private fun observeDataRequest() {

        viewModel.movieDetails.observe(this){
            if (it is Movie){
                binding.details.text = "" + it
            } else if (it == "error"){

            }
        }

        viewModel.movieSuggestions.observe(this){
            if (it is List<*>){
                binding.suggestion.text = "" + it
            } else if (it == "error"){

            }
        }

    }
}