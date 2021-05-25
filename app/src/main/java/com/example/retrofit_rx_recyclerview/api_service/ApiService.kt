package com.example.retrofit_rx_recyclerview.api_service

import com.example.retrofit_rx_recyclerview.RequestData
import com.example.retrofit_rx_recyclerview.model.Base
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("LoadCategoryWithPost2")
    fun post(@Body requestData: RequestData): Observable<Base>
}