package com.andromite.moviessuggestions.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.network.models.Movy
import com.bumptech.glide.Glide

class MoviesAdapter(var moviesList : List<Movy>, var context: Context) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = moviesList[position].titleEnglish
        holder.yearTextView.text = moviesList[position].year.toString()
        holder.ratingTextView.text = moviesList[position].rating.toString()
        holder.genreTextView.text = moviesList[position].genres.toString()

        Glide.with(context).load(moviesList[position].largeCoverImage).into(holder.posterImageView)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val posterImageView = itemView.findViewById<ImageView>(R.id.posterImageView)
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val yearTextView = itemView.findViewById<TextView>(R.id.yearTextView)
        val ratingTextView = itemView.findViewById<TextView>(R.id.ratingTextView)
        val genreTextView = itemView.findViewById<TextView>(R.id.genreTextView)
    }
}