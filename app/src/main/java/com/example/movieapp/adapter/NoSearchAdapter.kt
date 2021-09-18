package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.remote.entity.FilmSearch
import com.example.movieapp.data.remote.entity.TopMovie
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class NoSearchAdapter(
    var Onclick: OnClickItemNoSearch
) : RecyclerView.Adapter<NoSearchAdapter.NoSearchViewHolder>() {
    private var dataList: List<TopMovie> = ArrayList<TopMovie>()

    fun setData(list: List<TopMovie>) {
        this.dataList = list
    }

    inner class NoSearchViewHolder(var itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun OnBinData(film: TopMovie) {
            itemView.movie_item_layout_title.text = film.title
            itemView.movie_item_layout_year.text = film.year
            Glide.with(itemView.context).load(film.image).into(itemView.movie_item_layout_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoSearchViewHolder {
        return NoSearchViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoSearchViewHolder, position: Int) {
        val film_item: TopMovie = dataList.get(position)
        holder.itemview.setOnClickListener() { Onclick.OnClickItem(film_item) }
        return holder.OnBinData(film_item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

interface OnClickItemNoSearch {
    fun OnClickItem(film: TopMovie)
}