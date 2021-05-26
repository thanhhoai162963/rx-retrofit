package com.example.retrofit_rx_recyclerview.model.comments

import com.example.retrofit_rx_recyclerview.model.detail.DataList
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName

data class Comments (
    @SerialName("utcTime0")
    @Expose
    val utcTime0: String? = null,

    @SerialName("success")
    @Expose
    val success: Boolean? = null,

    @SerialName("message")
    @Expose
    val message: String? = null,

    @SerialName("data")
    @Expose
    val data: DataList? = null
)
