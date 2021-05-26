package com.example.retrofit_rx_recyclerview.model.comments

import com.google.gson.annotations.SerializedName

data class ListComments (
    @SerializedName("msgContent")
    val msgContent:String? = null,

    @SerializedName("createByAvatar")
    val createByAvatar:String? = null,

    @SerializedName("onDate")
    val onDate:String? = null,

    @SerializedName("createByName")
    val createByName:String? = null


)