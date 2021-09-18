package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.model.Movie
import com.example.movieapp.data.remote.entity.TopMovie
import kotlinx.android.synthetic.main.top_movie_item_layout.view.*

class WatchAdapter(var onClick: OnClickWatch) :
    RecyclerView.Adapter<WatchAdapter.WatchViewHolder>() {
    private var dataList: List<Movie> = ArrayList<Movie>()

    fun setData(list: List<Movie>){
        dataList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchViewHolder {
        return WatchViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.top_movie_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WatchViewHolder, position: Int) {
        val m = dataList.get(position)
        holder.onBindData(m)
        holder.itemView.setOnClickListener(
            View.OnClickListener {
                onClick.clickOnItem(m)
            }
        )
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class WatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBindData(m: Movie) {
            itemView.txt_film.text = m.name
            Glide.with(itemView.context).load(m.img).into(itemView.image_popular)
        }
    }
}

interface OnClickWatch {
    fun clickOnItem(m: Movie)
}