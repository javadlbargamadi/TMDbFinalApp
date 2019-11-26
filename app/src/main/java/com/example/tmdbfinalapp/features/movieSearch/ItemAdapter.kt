package com.example.tmdbfinalapp.features.movieSearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbfinalapp.R
import com.example.tmdbfinalapp.pojo.TMDbClass

class ItemAdapter(private val tmDbClass: TMDbClass, private val activityFunction: (Int) -> Unit) :
    RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = tmDbClass.results?.size ?: 0

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(tmDbClass.results!![position], activityFunction)
    }
}