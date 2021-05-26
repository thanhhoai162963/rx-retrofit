package com.example.retrofit_rx_recyclerview.adapter

import android.annotation.SuppressLint
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
import com.example.retrofit_rx_recyclerview.model.list.CategorySub
import kotlinx.android.synthetic.main.item_medicine.view.*

class MedicineAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mDataList  : List<CategorySub>?=null
    private lateinit var context  : Context

    fun setData(data : List<CategorySub>, context: Context){
        mDataList=data
        this.context = context
    }


    inner class MedicideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        @SuppressLint("CheckResult")
        fun bind(listCategorySub: CategorySub){
            itemView.tV_info.text = listCategorySub.title
            itemView.tVDateTime.text = listCategorySub.onDate
            if(listCategorySub.avatar != null) {
                Glide.with(context)
                    .load(listCategorySub.avatar)
                    .placeholder(R.drawable.ic_launcher_background)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .fitCenter()
                    .transform(CenterInside(),RoundedCorners(25))
                    .into(itemView.image1)
            }else {
                itemView.image1.setImageResource(R.drawable.ic_launcher_background)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicine,parent,false)
        return MedicideViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MedicideViewHolder){
            mDataList?.get(position)?.let { holder.bind(it) }
        }
    }

    override fun getItemCount(): Int {
        return mDataList?.size!!
    }



}