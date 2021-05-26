package com.example.retrofit_rx_recyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.webkit.WebView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.retrofit_rx_recyclerview.databinding.ActivityDetailBinding
import com.example.retrofit_rx_recyclerview.model.detail.DataList
import com.example.retrofit_rx_recyclerview.model.detail.Detail
import com.example.retrofit_rx_recyclerview.request.RequestDataDetail
import com.example.retrofit_rx_recyclerview.retrofit.ServiceBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.serialization.Serializable
import retrofit2.Retrofit

class DetailActivity : AppCompatActivity() {


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val intent = intent
        val postSignature = intent.getStringExtra(Constant.POST_SIGNATURE)
        Log.d("bbb1",postSignature.toString())
        val requestDataDetail = postSignature?.let { RequestDataDetail(2, it) }
        if (requestDataDetail != null) {
            callApiDetail(requestDataDetail)
        }
    }
    fun callApiDetail(requestDataDetail: RequestDataDetail) {
        ServiceBuilder.instance.getApiService().postDetail(requestDataDetail)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<Detail>{
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(t: Detail?) {
                    var uri = t?.data?.msg?.msgContent
                    if (uri != null) {
                        initWebView(uri)
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onComplete() {
                }

            })
    }
    fun initWebView(uri:String){
        val encodedHtml = Base64.encodeToString(uri.toByteArray(), Base64.NO_PADDING)
        web_view.loadData(encodedHtml,"text/html","base64")
    }

}


