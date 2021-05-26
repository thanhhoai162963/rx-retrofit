package com.example.retrofit_rx_recyclerview.request

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDataDetail(
    @SerializedName("language")
    val language:Int = 0,

    @SerializedName("postSignature")
    val postSignature:String = ""
)