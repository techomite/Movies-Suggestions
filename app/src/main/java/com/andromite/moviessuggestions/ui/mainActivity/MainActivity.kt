package com.andromite.moviessuggestions.ui.mainActivity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andromite.moviessuggestions.databinding.ActivityMainBinding
import com.andromite.moviessuggestions.network.models.Movy
import com.andromite.moviessuggestions.utils.PaginationScrollListener
import com.andromite.moviessuggestions.utils.Utils


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : MoviesAdapter

    private val pageStart: Int = 1
    private var isLoading: Boolean = false
    private var isLastPage: Boolean = false
    private var totalPages: Int = 1
    private var currentPage: Int = pageStart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        initRecyclerView()
        observerDataRequest()
    }

    private fun observerDataRequest() {
        viewModel.moviesListFirstTime.observe(this) {
            // add data to adapter
            val results: MutableList<Movy> = it.movies as MutableList<Movy>
            adapter.addAll(results)

            totalPages = it.movieCount!!

            if (currentPage <= totalPages) adapter.addLoadingFooter()
            else isLastPage = true
        }

        viewModel.moviesListSecondTime.observe(this) {
            // add data to adapter
            val results: MutableList<Movy> = it.movies as MutableList<Movy>
            adapter.removeLoadingFooter()
            isLoading = false
            adapter.addAll(results)

            if (currentPage != totalPages) adapter.addLoadingFooter()
            else isLastPage = true
        }
    }

    private fun initRecyclerView(){
        adapter = MoviesAdapter(this)
        val layoutManager = LinearLayoutManager(this)

        binding.rvList.adapter = adapter
        binding.rvList.setHasFixedSize(true)
        binding.rvList.layoutManager = layoutManager

        loadFirstPage()

        binding.rvList.addOnScrollListener(object : PaginationScrollListener(layoutManager){
            override fun loadMoreItems() {
                Utils.floge("inside loadMoreItems")
                isLoading = true
                currentPage += 1

                Handler(Looper.myLooper()!!).postDelayed({
                    loadNextPage()
                }, 1000)
            }

            override fun getTotalPageCount(): Int {
                return totalPages
            }

            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

        })
    }

    private fun loadFirstPage() {
        viewModel.getMoviesList(currentPage)
    }

    private fun loadNextPage() {
        viewModel.getMoviesList(currentPage)
    }
}