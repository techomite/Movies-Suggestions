package com.andromite.moviessuggestions.ui.movieDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.andromite.moviessuggestions.databinding.ActivitySearchBinding
import com.andromite.moviessuggestions.network.models.movieDetails.Movie
import com.bumptech.glide.Glide

class MoviesDetailsActivity : AppCompatActivity() {

    lateinit var binding : ActivitySearchBinding
    lateinit var viewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]

        val movieId = intent.getIntExtra("movieId",0)

        viewModel.getMovieDetails(movieId)
        viewModel.getMovieSuggestion(movieId)
        observeDataRequest()
    }

    private fun observeDataRequest() {

        viewModel.movieDetails.observe(this){
            if (it is Movie){
                setMoviesData(it as Movie)
            } else if (it == "error"){

            }
        }

        viewModel.movieSuggestions.observe(this){
            if (it is List<*>){

            } else if (it == "error"){

            }
        }

    }

    fun setMoviesData(movie: Movie) {
        binding.apply {

            Glide.with(this@MoviesDetailsActivity).load(movie.mediumCoverImage).dontTransform().into(posterImageView)

            titleTextView.text = movie.titleLong
        }
    }
}