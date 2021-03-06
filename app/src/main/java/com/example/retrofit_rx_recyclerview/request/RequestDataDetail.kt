package com.example.retrofit_rx_recyclerview.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDataDetail(
    @SerializedName("language")
    @Expose
    val language: Int? = null,

    @SerializedName("postSignature")
    @Expose
    val postSignature: String? = null
)