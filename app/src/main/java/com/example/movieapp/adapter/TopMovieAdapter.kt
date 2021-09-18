package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.remote.entity.TopMovie
import kotlinx.android.synthetic.main.top_movie_item_layout.view.*

class TopMovieAdapter(var onClick: OnClickTopMovie) :
    RecyclerView.Adapter<TopMovieAdapter.TopMovieViewHolder>() {
    private var dataList: List<TopMovie> = ArrayList<TopMovie>()

    fun setData(list: List<TopMovie>){
        dataList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder {
        return TopMovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.top_movie_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {
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

    class TopMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBindData(m: TopMovie) {
            itemView.txt_film.text = m.title
            Glide.with(itemView.context).load(m.image).into(itemView.image_popular)
        }
    }
}

interface OnClickTopMovie {
    fun clickOnItem(m: TopMovie)
}