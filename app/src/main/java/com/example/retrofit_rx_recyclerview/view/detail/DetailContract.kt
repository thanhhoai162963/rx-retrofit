package com.example.retrofit_rx_recyclerview.view.detail

import com.example.retrofit_rx_recyclerview.model.detail.Detail

interface DetailContract {
    interface View {
        fun onCompleteDetail(detail: Detail)
        fun onFailDetail()
        fun onShowProgressBar()
    }
    interface Presenter{
        fun callApi(postSignature:String)
    }
}