package com.example.retrofit_rx_recyclerview.api_service

import com.example.retrofit_rx_recyclerview.model.detail.DataList
import com.example.retrofit_rx_recyclerview.model.detail.Detail
import com.example.retrofit_rx_recyclerview.request.RequestDataList
import com.example.retrofit_rx_recyclerview.model.list.Base
import com.example.retrofit_rx_recyclerview.request.RequestDataDetail
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("LoadCategoryWithPost2")
    fun post(@Body requestDataList: RequestDataList): Observable<Base>

    @POST("LoadPostDetail2")
    fun postDetail(@Body requestDataDetail: RequestDataDetail) : Observable<Detail>
}