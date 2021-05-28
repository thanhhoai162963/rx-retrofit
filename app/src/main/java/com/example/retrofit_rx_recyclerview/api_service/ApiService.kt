package com.example.retrofit_rx_recyclerview.api_service

import com.example.retrofit_rx_recyclerview.model.comments.Comments
import com.example.retrofit_rx_recyclerview.model.detail.Detail
import com.example.retrofit_rx_recyclerview.request.LoadCategoryWithPost2Request
import com.example.retrofit_rx_recyclerview.model.list.LoadCategoryWithPost2Response
import com.example.retrofit_rx_recyclerview.request.RequestDataComments
import com.example.retrofit_rx_recyclerview.request.RequestDataDetail
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("LoadCategoryWithPost2")
    fun loadCategoryWithPost2(@Body requestDataList: LoadCategoryWithPost2Request): Observable<LoadCategoryWithPost2Response>

    @POST("LoadPostDetail2")
    fun postDetail(@Body requestDataDetail: RequestDataDetail?) : Observable<Detail>

    @POST("LoadComments2")
    fun postComment(@Body requestDataComments: RequestDataComments) : Observable<Comments>
}