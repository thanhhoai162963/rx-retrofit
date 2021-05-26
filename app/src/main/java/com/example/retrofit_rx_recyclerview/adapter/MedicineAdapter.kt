package com.example.retrofit_rx_recyclerview.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.retrofit_rx_recyclerview.Constant
import com.example.retrofit_rx_recyclerview.DetailActivity
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
            itemView.tcDateTime.text = listCategorySub.onDate
                Glide.with(context)
                    .load(listCategorySub.avatar)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .fitCenter()
                    .transform(CenterInside(),RoundedCorners(25))
                    .into(itemView.image1)

            itemView.setOnClickListener {
                Log.d("bbb1",listCategorySub.postSignature.toString())
                val intent = Intent(context,DetailActivity::class.java)
                intent.putExtra(Constant.POST_SIGNATURE,listCategorySub.postSignature)
                context.startActivity(intent)
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