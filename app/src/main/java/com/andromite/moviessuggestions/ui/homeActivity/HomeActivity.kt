package com.andromite.moviessuggestions.ui.homeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.andromite.moviessuggestions.databinding.ActivityHomeBinding
import com.andromite.moviessuggestions.network.models.ChildItem
import com.andromite.moviessuggestions.network.models.ParentItem
import com.andromite.moviessuggestions.network.models.movieList.MoviesListData

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
        viewModel.getActionList()
        viewModel.get3DList()
        viewModel.getComedyList()
        viewModel.getHorrorList()
        viewModel.getScifiList()


    }

    private fun registerDataRequest() {
        viewModel.trendingList.observe(this){
            var parentItem = ParentItem("Trending", getChildList(it))
            adapter.add(parentItem)
        }

        viewModel.latestList.observe(this){
            val parentItem = ParentItem("Latest", getChildList(it))
            adapter.add(parentItem)
        }

        viewModel.actionList.observe(this){
            val parentItem = ParentItem("Action", getChildList(it))
            adapter.add(parentItem)
        }

        viewModel.list3d.observe(this){
            val parentItem = ParentItem("3D", getChildList(it))
            adapter.add(parentItem)
        }

        viewModel.comedyList.observe(this){
            val parentItem = ParentItem("Comedy", getChildList(it))
            adapter.add(parentItem)
        }

        viewModel.horrorList.observe(this){
            val parentItem = ParentItem("Horror", getChildList(it))
            adapter.add(parentItem)
        }

        viewModel.scifiList.observe(this){
            val parentItem = ParentItem("Sci-Fi", getChildList(it))
            adapter.add(parentItem)
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
}