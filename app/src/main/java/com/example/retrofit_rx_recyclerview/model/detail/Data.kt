package com.example.retrofit_rx_recyclerview.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataList (
    @SerializedName("countLike")
    @Expose
    val countLike:Int? = null,

    @SerializedName("countView")
    @Expose
    val countView:Int? = null,

    @SerializedName("countComment")
    @Expose
    val countComment:Int? = null,

    @SerializedName("msg")
    @Expose
    val msg:Msg? = null
)