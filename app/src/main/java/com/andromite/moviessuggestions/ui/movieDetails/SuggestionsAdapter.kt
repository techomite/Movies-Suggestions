package com.andromite.moviessuggestions.ui.movieDetails

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.network.models.movieDetails.Torrent
import com.andromite.moviessuggestions.network.models.movieList.Movy
import com.andromite.moviessuggestions.network.models.movieSuggestion.SuggestionMovy
import com.bumptech.glide.Glide


class SuggestionsAdapter(private var context: Context) : RecyclerView.Adapter<SuggestionsAdapter.ViewHolder>() {

    private val torrentList : MutableList<SuggestionMovy> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_layout, parent, false)
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
        val posterImageView = itemView.findViewById<ImageView>(R.id.posterImageView)
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val root = itemView.findViewById<ConstraintLayout>(R.id.root)


        fun bind(model: SuggestionMovy, context: Context) {
            titleTextView.text = model.titleEnglish

            Glide.with(context).load(model.mediumCoverImage)
                .into(posterImageView)

            root.setOnClickListener {
                val intent = Intent(context, MoviesDetailsActivity::class.java)
                intent.putExtra("movieId", model.id)
                context.startActivity(intent)
            }
        }
    }

    fun addAll(movies: MutableList<SuggestionMovy>) {
        for(movie in movies){
            torrentList.add(movie)
        }
    }
}