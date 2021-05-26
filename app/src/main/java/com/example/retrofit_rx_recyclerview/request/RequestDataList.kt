package com.example.retrofit_rx_recyclerview.request
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestDataList(

    @SerialName("categoryType")
    val categoryType: Int = 0,

    @SerialName("language")
    val language: Int = 0,

    @SerialName("page")
    val page: Int = 0,

    @SerialName("pageSize")
    val pageSize: Int = 0
)