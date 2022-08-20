package com.andromite.moviessuggestions.ui.movieDetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.network.models.movieDetails.Torrent
import com.andromite.moviessuggestions.network.models.movieSuggestion.SuggestionMovy


class TorrentAdapter(private var context: Context) : RecyclerView.Adapter<TorrentAdapter.ViewHolder>() {

    private val torrentList : MutableList<Torrent> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.torrent_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val torrent = torrentList[position]
        val viewholder : ViewHolder = holder
        viewholder.bind(torrent,context)
     }

    override fun getItemCount(): Int {
        return if (torrentList.size > 0) torrentList.size else 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val filSizeTextView: TextView = view.findViewById(R.id.filSizeTextView)
        private val typeTextView: TextView = view.findViewById(R.id.typeTextView)
        private val qualityTextView : TextView = view.findViewById(R.id.qualityTextView)
        private val downloadButton: Button = view.findViewById(R.id.downloadButton)

        fun bind(torrent: Torrent, context: Context) {
            filSizeTextView.text = torrent.size
            typeTextView.text = torrent.type
            qualityTextView.text = torrent.quality
            downloadButton.text = torrent.quality

            downloadButton.setOnClickListener {
                val uri: Uri = Uri.parse(torrent.url)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
        }

    }

    fun addAll(torrents: MutableList<Torrent>) {
        for(tor in torrents){
            torrentList.add(tor)
        }
    }
}