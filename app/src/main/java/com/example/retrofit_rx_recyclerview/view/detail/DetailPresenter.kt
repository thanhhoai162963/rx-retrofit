package com.example.retrofit_rx_recyclerview.view.detail

import com.example.retrofit_rx_recyclerview.model.detail.Detail
import com.example.retrofit_rx_recyclerview.request.RequestDataDetail
import com.example.retrofit_rx_recyclerview.retrofit.ServiceBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.security.Signature

class DetailPresenter(val stateViewDetail: DetailContract.View) : DetailContract.Presenter {

    override fun callApi(postSignature: String) {
        val requestDataDetail = RequestDataDetail(1,postSignature)
        ServiceBuilder.instance.getApiService().postDetail(requestDataDetail)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Detail>{
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(t: Detail?) {
                    if (t != null) {
                        stateViewDetail.onCompleteDetail(t)
                    }else
                        stateViewDetail.onFailDetail()
                }

                override fun onError(e: Throwable?) {
                }

                override fun onComplete() {
                    stateViewDetail.onShowProgressBar()
                }

            })
    }
}