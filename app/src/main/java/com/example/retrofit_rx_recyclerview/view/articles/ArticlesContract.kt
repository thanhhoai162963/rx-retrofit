package com.example.retrofit_rx_recyclerview.view.articles

import com.example.retrofit_rx_recyclerview.model.list.LoadCategoryWithPost2Response

interface ArticlesContract {
    interface View{
        fun onCompleteArticle(base: LoadCategoryWithPost2Response)
        fun onFailArticle(msg:String)
        fun onShowProgressBar()
    }
    interface Presenter{
        fun callApi(page :Int)
    }
}