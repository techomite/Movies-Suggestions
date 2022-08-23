package com.andromite.moviessuggestions.ui.homeActivity

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.network.models.ChildItem
import com.andromite.moviessuggestions.ui.movieDetails.MoviesDetailsActivity
import com.andromite.moviessuggestions.utils.Utils
import com.bumptech.glide.Glide

class ChildItemAdapter(var context: Context) : RecyclerView.Adapter<ChildItemAdapter.ViewHolder>() {

    var childItemList : MutableList<ChildItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_recylerview_item,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = childItemList[position]
        holder.bind(child, context)
    }

    override fun getItemCount(): Int {
        return if (childItemList.size > 0) childItemList.size else 0
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        var poster = view.findViewById<ImageView>(R.id.posterImageView)

        fun bind(child: ChildItem, context: Context) {

            Glide.with(context).load(child.poster).into(poster)

            itemView.setOnClickListener {
                Utils.floge("id: ${child.id}")
                val intent = Intent(context, MoviesDetailsActivity::class.java)
                intent.putExtra("movieId", child.id)
                context.startActivity(intent)
            }

        }

    }

    fun addAll(childItems: MutableList<ChildItem>) {
        for(tor in childItems){
            childItemList.add(tor)
            notifyItemInserted(childItemList.size - 1)
        }
    }
}