package com.example.movieapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.remote.entity.ActorDetail
import kotlinx.android.synthetic.main.actor_item_layout.view.*

class ActorDetailAdapter: RecyclerView.Adapter<ActorDetailAdapter.ActorViewHolder>() {
   private var dataList = ArrayList<ActorDetail>()

    fun setData(list: ArrayList<ActorDetail>){
        this.dataList = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorDetailAdapter.ActorViewHolder {
        return ActorViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.actor_item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ActorDetailAdapter.ActorViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        holder.bindData(dataModel)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ActorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(a: ActorDetail) {
            itemView.actor_item_layout_txt_name.text = a.name
            Glide.with(itemView.context).load(a.image).into(itemView.actor_item_layout_img)
        }
    }
}