package com.example.retrofit_rx_recyclerview.model.detail

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Msg(
    @SerializedName("language")
    @Expose
    val language: String? = null,

    @SerializedName("pageSize")
    @Expose
    val pageSize: String? = null,

    @SerializedName("msgContent")
    @Expose
    val msgContent: String? = null
) : Serializable