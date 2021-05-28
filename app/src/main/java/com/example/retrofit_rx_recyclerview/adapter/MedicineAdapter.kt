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
import com.example.retrofit_rx_recyclerview.ultil.Constant
import com.example.retrofit_rx_recyclerview.view.detail.DetailActivity
import com.example.retrofit_rx_recyclerview.R
import com.example.retrofit_rx_recyclerview.model.list.CategorySub
import kotlinx.android.synthetic.main.item_medicine.view.*

class MedicineAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mDataList: MutableList<CategorySub>? = null
    private lateinit var context: Context

    fun setData(data: List<CategorySub>, context: Context) {
        val temp = data as ArrayList
        mDataList = temp
        this.context = context
    }

    fun addData(data: List<CategorySub>) {
        mDataList?.addAll(data)
    }

    inner class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("CheckResult")
        fun bind(listCategorySub: CategorySub) {

            itemView.tV_info.text = listCategorySub.title
            itemView.tcDateTime.text = listCategorySub.onDate
            glideBuilder(context, itemView, listCategorySub)

            itemView.setOnClickListener {
                Log.d("bbb1", listCategorySub.postSignature.toString())
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(Constant.POST_SIGNATURE, listCategorySub.postSignature)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MedicineViewHolder) {
            mDataList?.get(position)?.let { holder.bind(it) }
        }
    }

    override fun getItemCount(): Int {
        return mDataList?.size!!
    }

    fun glideBuilder(context: Context, itemView: View, listCategorySub: CategorySub) {
        Glide.with(context)
            .load(listCategorySub.avatar)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .fitCenter()
            .transform(CenterInside(), RoundedCorners(25))
            .into(itemView.image1)
    }


}