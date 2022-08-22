package com.andromite.moviessuggestions.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andromite.moviessuggestions.databinding.ActivitySearchBinding
import com.andromite.moviessuggestions.network.models.movieList.Movy
import com.andromite.moviessuggestions.utils.Utils
import com.jakewharton.rxbinding.widget.RxTextView
import java.sql.Time
import java.util.concurrent.TimeUnit

class SearchActivity : AppCompatActivity() {

    lateinit var binding : ActivitySearchBinding
    lateinit var viewModel: SearchViewModel
    lateinit var adapter : SearchListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)
        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        initRV()
        registerDataObservers()

        binding.pbview.progressbar.visibility = View.GONE

        binding.searchButton.setOnClickListener {
            binding.pbview.progressbar.visibility = View.VISIBLE
            Utils.hideKeyboard(this@SearchActivity)
            callSearchAPI(binding.searchEditText.text.toString())
        }
    }

    private fun initRV() {
        binding.apply {
            adapter = SearchListAdapter(this@SearchActivity)
            searchListRV.layoutManager = LinearLayoutManager(this@SearchActivity, LinearLayoutManager.VERTICAL, false)
            searchListRV.adapter = adapter
        }
    }

    private fun registerDataObservers() {
        viewModel.searchList.observe(this){
            binding.pbview.progressbar.visibility = View.GONE
            val results: MutableList<Movy> = it.movies as MutableList<Movy>
            adapter.addAll(results)
        }
    }

    private fun callSearchAPI(searchTerm: String){
        binding.pbview.progressbar.visibility = View.VISIBLE
        adapter.clearList()
        viewModel.getSearchList(searchTerm)
    }
}