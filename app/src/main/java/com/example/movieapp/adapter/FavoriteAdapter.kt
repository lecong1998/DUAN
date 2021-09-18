package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.model.Movie


import kotlinx.android.synthetic.main.movie_item_layout.view.*

class FavoriteAdapter(val onclick:OnClickItem):RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private var listdata : List<Movie> = ArrayList<Movie>()
    fun setData(list :List<Movie>){
        this.listdata=list
    }
    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun onBind(movie: Movie){
            itemView.movie_item_layout_title.text = movie.name
            itemView.movie_item_layout_year.text = movie.genre
            Glide.with(itemView.context).load(movie.img).into(itemView.movie_item_layout_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item_layout,parent,false))
    }

    override fun onBindViewHolder(holder: FavoriteAdapter.ViewHolder, position: Int) {
        val m = listdata[position]
        holder.onBind(m)
        holder.itemView.setOnClickListener {
            onclick.oclick(m)
        }

    }

    override fun getItemCount(): Int {
        return listdata.size
    }

}
interface OnClickItem {
    fun oclick(movie: Movie)
}
