package com.example.retrofit_rx_recyclerview.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class LoadCategoryWithPost2Request(

    @SerialName("categoryType")
    val categoryType: Int = 0,
    @SerialName("language")
    val language: Int = 0,
    @SerialName("page")
    val page: Int = 0,
    @SerialName("pageSize")
    val pageSize: Int = 0
)