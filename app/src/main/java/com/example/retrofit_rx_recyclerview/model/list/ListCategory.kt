package com.example.retrofit_rx_recyclerview.model.list

import com.example.retrofit_rx_recyclerview.model.list.CategorySub
import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

class ListCategory {
    @SerialName("isHotTitle")
    @Expose
    val isHotTitle: Boolean? = null

    @SerialName("title")
    @Expose
    val title: String? = null

    @SerialName("list")
    @Expose
    val list: List<CategorySub>? = null
}