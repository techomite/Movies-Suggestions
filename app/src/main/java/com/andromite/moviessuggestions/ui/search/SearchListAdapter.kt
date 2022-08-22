package com.andromite.moviessuggestions.ui.search

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.network.models.movieList.Movy
import com.andromite.moviessuggestions.ui.movieDetails.MoviesDetailsActivity
import com.bumptech.glide.Glide


class SearchListAdapter(private var context: Context) : RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    private val searchList : MutableList<Movy> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_search_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = searchList[position]
        val viewholder : ViewHolder = holder
        viewholder.bind(movie,context)
     }

    override fun getItemCount(): Int {
        return if (searchList.size > 0) searchList.size else 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        private val yearTextView: TextView = view.findViewById(R.id.yearTextView)
        private val ratingTextView: TextView = view.findViewById(R.id.ratingTextView)
        private val genreTextView: TextView = view.findViewById(R.id.genreTextView)
        private val posterImageView: ImageView = view.findViewById(R.id.posterImageView)

        fun bind(movie: Movy, context: Context) {
            titleTextView.text = movie.title
            yearTextView.text = movie.year.toString()
            ratingTextView.text = movie.rating.toString()
            genreTextView.text = movie.genres.toString()

            Glide.with(context).load(movie.mediumCoverImage).into(posterImageView)

            itemView.setOnClickListener {
                val intent = Intent(context, MoviesDetailsActivity::class.java)
                intent.putExtra("movieId", movie.id)
                context.startActivity(intent)
            }



        }

    }

    fun addAll(torrents: MutableList<Movy>) {
        for(tor in torrents){
            searchList.add(tor)
            notifyItemInserted(searchList.size - 1)
        }
    }

    fun clearList(){
        searchList.clear()
    }
}