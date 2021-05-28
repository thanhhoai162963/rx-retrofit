package com.example.retrofit_rx_recyclerview.retrofit

import com.example.retrofit_rx_recyclerview.api_service.ApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ServiceBuilder {
    private lateinit var retrofit: Retrofit

    companion object {
        val baseURL = "https://apis1.globedr.com/api/v1/Forum/"
        val instance = ServiceBuilder()

    }

    init {
        configService()
    }

    private fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }

    private fun configService() {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(OAuthInterceptor())
            .addInterceptor(logging)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()


        retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    class OAuthInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            var request = chain.request()
            request = request.newBuilder().build()
            return chain.proceed(request)
        }
    }

    fun getApiService(): ApiService {
        return buildService(ApiService::class.java)
    }

}