package com.example.retrofit_rx_recyclerview.model.list

import com.google.gson.annotations.Expose
import kotlinx.serialization.SerialName

class Base{
    @SerialName("utcTime0")
    @Expose
    val utcTime0: String? = null

    @SerialName("success")
    @Expose
    val success: Boolean? = null

    @SerialName("message")
    @Expose
    val message: String? = null

    @SerialName("data")
    @Expose
    val data: Data? = null

}