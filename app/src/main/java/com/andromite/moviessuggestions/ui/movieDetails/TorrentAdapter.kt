package com.andromite.moviessuggestions.ui.movieDetails

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.network.models.movieDetails.Torrent

class TorrentAdapter : RecyclerView.Adapter<TorrentAdapter.ViewHolder>() {

    val torrentList : MutableList<Torrent> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return if (torrentList.size > 0) torrentList.size else 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }


    fun addAll(torrents: MutableList<Torrent>) {
        for(tor in torrents){
            torrentList.add(tor)
        }
    }
}