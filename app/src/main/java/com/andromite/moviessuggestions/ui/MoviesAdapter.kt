package com.andromite.moviessuggestions.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.network.models.Movy
import com.bumptech.glide.Glide


class MoviesAdapter(var context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val item: Int = 0
    private val loading: Int = 1

    private var isLoadingAdded: Boolean = false
    private var retryPageLoad: Boolean = false

    private var errorMsg: String? = ""

    private var moviesModels: MutableList<Movy> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return  if(viewType == item){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.movies_layout, parent, false)
            ViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_loading, parent, false)
            LoadingVH(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val model = moviesModels[position]
        if(getItemViewType(position) == item){
            val myOrderVH: ViewHolder = holder as ViewHolder
            myOrderVH.bind(model, context)
        }else{
            val loadingVH: LoadingVH = holder as LoadingVH
                loadingVH.progressbar.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return if (moviesModels.size > 0) moviesModels.size else 0
    }

    override fun getItemViewType(position: Int): Int {
        return if(position == 0){
            item
        }else {
            if (position == moviesModels.size - 1 && isLoadingAdded) {
                loading
            } else {
                item
            }
        }
    }



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val posterImageView = itemView.findViewById<ImageView>(R.id.posterImageView)
        val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
        val yearTextView = itemView.findViewById<TextView>(R.id.yearTextView)
        val ratingTextView = itemView.findViewById<TextView>(R.id.ratingTextView)
        val genreTextView = itemView.findViewById<TextView>(R.id.genreTextView)

        fun bind(model: Movy, context : Context) {
           titleTextView.text = model.titleEnglish
           yearTextView.text = model.year.toString()
           ratingTextView.text = model.rating.toString()
           genreTextView.text = model.genres.toString()

            Glide.with(context).load(model.largeCoverImage).into(posterImageView)
        }
    }

    class LoadingVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val progressbar = itemView.findViewById<ProgressBar>(R.id.loadmore_progress)
    }

    fun showRetry(show: Boolean, errorMsg: String) {
        retryPageLoad = show
        notifyItemChanged(moviesModels.size - 1)
        this.errorMsg = errorMsg
    }

    fun addAll(movies: MutableList<Movy>) {
        for(movie in movies){
            add(movie)
        }
    }

    fun add(movy: Movy) {
        moviesModels.add(movy)
        notifyItemInserted(moviesModels.size - 1)
    }

    fun addLoadingFooter() {
        isLoadingAdded = true
        add(Movy())

    }

    fun removeLoadingFooter() {
        isLoadingAdded = false

        val position: Int =moviesModels.size -1
        val movie: Movy = moviesModels[position]

        if(movie != null){
            moviesModels.removeAt(position)
            notifyItemRemoved(position)
        }
    }
}