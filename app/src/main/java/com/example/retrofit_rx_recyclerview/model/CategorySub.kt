package com.example.retrofit_rx_recyclerview.model

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

class CategorySub {
    @SerialName("postSignature")
    @Expose
    val postSignature: String? = null

    @SerialName("title")
    @Expose
    val title: String? = null

}