package com.example.retrofit_rx_recyclerview.model.comments

import com.google.gson.annotations.SerializedName

data class DataComments (
    @SerializedName("pageSize")
    val pageSize:Int? = null,

    @SerializedName("total")
    val total:Int? = null,

    @SerializedName("list")
    val listCommnets:ListComments? = null,
)