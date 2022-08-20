package com.andromite.moviessuggestions.ui.movieDetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.bumptech.glide.Glide


class ScreenshotAdapter(private var context: Context) : RecyclerView.Adapter<ScreenshotAdapter.ViewHolder>() {

    private val screenshotList : MutableList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.screenshot_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val screenshot = screenshotList[position]
        val viewholder : ViewHolder = holder
        viewholder.bind(screenshot,context)
     }

    override fun getItemCount(): Int {
        return if (screenshotList.size > 0) screenshotList.size else 0
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val screenshotImageView: ImageView = view.findViewById(R.id.screenshotImageView)

        fun bind(screenshot: String, context: Context) {
            Glide.with(context).load(screenshot).into(screenshotImageView)
        }

    }

    fun addAll(torrents: MutableList<String>) {
        for(tor in torrents){
            screenshotList.add(tor)
            notifyItemInserted(screenshotList.size - 1)
        }
    }
}