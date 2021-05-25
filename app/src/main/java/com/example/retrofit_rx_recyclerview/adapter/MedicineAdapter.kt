package com.example.retrofit_rx_recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_rx_recyclerview.R
import com.example.retrofit_rx_recyclerview.model.CategorySub
import kotlinx.android.synthetic.main.item_medicine.view.*

class MedicineAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mDataList  : List<CategorySub>?=null

    fun setData(data : List<CategorySub>){
        mDataList=data
    }


    inner class MedicideViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(listCategorySub: CategorySub){
            itemView.tV_info.text = listCategorySub.title

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