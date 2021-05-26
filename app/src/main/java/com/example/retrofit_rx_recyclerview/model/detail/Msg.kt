package com.example.retrofit_rx_recyclerview.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Msg (
    @SerializedName("msgContent")
    @Expose
    val msgContent:String? = null
)