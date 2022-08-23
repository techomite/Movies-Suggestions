package com.andromite.moviessuggestions.ui.homeActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andromite.moviessuggestions.R
import com.andromite.moviessuggestions.network.models.ChildItem
import com.andromite.moviessuggestions.network.models.ParentItem

class HomeAdapter(var context: Context) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    val parentItemsList :  MutableList<ParentItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = parentItemsList[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int {
        return if (parentItemsList.size > 0) parentItemsList.size else 0
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var title = view.findViewById<TextView>(R.id.parent_item_title)
        var childRecyclerView = view.findViewById<RecyclerView>(R.id.child_recyclerview)
        fun bind(item: ParentItem, context: Context) {

            title.text = item.parentTitle

            childRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            val adapter = ChildItemAdapter(context)
            childRecyclerView.adapter = adapter

            adapter.addAll(item.childList as MutableList<ChildItem>)


        }

    }

    fun addAll(parentItems: MutableList<ParentItem>) {
        for(item in parentItems){
            parentItemsList.add(item)
            notifyItemInserted(parentItemsList.size - 1)
        }
    }

    fun add(item: ParentItem) {
            parentItemsList.add(item)
            notifyItemInserted(parentItemsList.size - 1)
    }




}