package com.andromite.moviessuggestions.ui.homeActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.databinding.ActivityHomeBinding
import com.andromite.moviessuggestions.network.models.ChildItem
import com.andromite.moviessuggestions.network.models.ParentItem
import com.andromite.moviessuggestions.network.models.movieList.MoviesListData
import com.andromite.moviessuggestions.ui.search.SearchActivity

class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding
    lateinit var viewModel: HomeViewModel
    lateinit var adapter : HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        adapter = HomeAdapter(this)

        initRecyclerview()
        registerDataRequest()

        viewModel.getTrendingList()
        viewModel.getLatestList()
        viewModel.getAdventureList()
        viewModel.getComedyList()
        viewModel.getHorrorList()


    }

    private fun registerDataRequest() {
        viewModel.trendingList.observe(this){
            var parentItem = ParentItem("Trending", getChildList(it))
            adapter.add(parentItem)
            binding.pbview.progressbar.visibility = View.GONE
        }

        viewModel.latestList.observe(this){
            val parentItem = ParentItem("Latest", getChildList(it))
            adapter.add(parentItem)
            binding.pbview.progressbar.visibility = View.GONE
        }

        viewModel.adventureList.observe(this){
            val parentItem = ParentItem("Adventure", getChildList(it))
            adapter.add(parentItem)
            binding.pbview.progressbar.visibility = View.GONE
        }


        viewModel.comedyList.observe(this){
            val parentItem = ParentItem("Comedy", getChildList(it))
            adapter.add(parentItem)
            binding.pbview.progressbar.visibility = View.GONE
        }

        viewModel.horrorList.observe(this){
            val parentItem = ParentItem("Horror", getChildList(it))
            adapter.add(parentItem)
            binding.pbview.progressbar.visibility = View.GONE
        }

    }

    private fun initRecyclerview() {

        binding.parentRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.parentRecyclerView.adapter = adapter

    }

    private fun getChildList(moviesListData: MoviesListData): MutableList<ChildItem> {
        var childItemList : MutableList<ChildItem> = ArrayList()
        for (count in 0 until moviesListData.movies?.size!!){
            val child = moviesListData.movies[count]
            val item = ChildItem(child?.titleEnglish,child?.mediumCoverImage, child?.id)
            childItemList.add(item)
        }
        return childItemList
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.searchMenu -> {
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}