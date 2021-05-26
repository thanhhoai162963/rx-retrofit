package com.example.retrofit_rx_recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.retrofit_rx_recyclerview.R
import com.example.retrofit_rx_recyclerview.model.comments.ListComments
import kotlinx.android.synthetic.main.item_comments.view.*


class CommentAdapter(var listComment: List<ListComments>,var context:Context) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(listComment: ListComments){
            itemView.text_name.text = listComment.createByName
            itemView.text_time.text = listComment.onDate
            itemView.text_info.text = listComment.msgContent
            Glide.with(context)
                .load(listComment.createByAvatar)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .fitCenter()
                .transform(CenterInside(),RoundedCorners(25))
                .into(image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comments,parent,false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommentViewHolder){
            listComment.get(position).let {
                holder.bind(it)
            }
        }
    }

    override fun getItemCount(): Int {
        return listComment.size
    }
}