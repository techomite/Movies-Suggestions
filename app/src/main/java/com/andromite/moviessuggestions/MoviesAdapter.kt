package com.andromite.moviessuggestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.network.models.MoviesList
import com.andromite.moviessuggestions.network.models.Movy

class MoviesAdapter(var moviesList : List<Movy>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = moviesList[position].titleEnglish
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }
}