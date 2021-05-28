package com.example.retrofit_rx_recyclerview.view.comment

import com.example.retrofit_rx_recyclerview.model.comments.Comments
import com.example.retrofit_rx_recyclerview.request.RequestDataComments

interface CommentsContract {
    interface View{
        fun onCompleteViewComment(comments: Comments)
        fun onFailViewComment()
        fun onShowProgressBar()
    }
    interface Presenter{
        fun callApi(postSignature: String)
    }
}