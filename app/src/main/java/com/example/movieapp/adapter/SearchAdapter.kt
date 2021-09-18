package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.remote.entity.FilmSearch
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class SearchAdapter (
    var Onclick : OnClickItemSearch
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var dataList: List<FilmSearch> = ArrayList<FilmSearch>()
    private var dataList_Filter: List<FilmSearch>? = dataList
    fun setData(list: List<FilmSearch>){
        this.dataList = list
    }
    inner class ViewHolder(var itemview : View) : RecyclerView.ViewHolder(itemview) {
        fun OnBinData( film: FilmSearch)
        {
            itemView.movie_item_layout_title.text = film.title
            itemView.movie_item_layout_year.text = film.description
            Glide.with(itemView.context).load(film.image).into(itemView.movie_item_layout_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item_layout,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val film_item: FilmSearch = dataList.get(position)
        holder.itemview.setOnClickListener(){Onclick.OnClickItem(film_item)}
        return holder.OnBinData(film_item)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

interface OnClickItemSearch {
    fun OnClickItem(film : FilmSearch)
}