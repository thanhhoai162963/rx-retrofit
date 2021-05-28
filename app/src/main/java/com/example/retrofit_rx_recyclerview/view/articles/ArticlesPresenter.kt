package com.example.retrofit_rx_recyclerview.view.articles

import android.util.Log
import com.example.retrofit_rx_recyclerview.model.list.LoadCategoryWithPost2Response
import com.example.retrofit_rx_recyclerview.request.LoadCategoryWithPost2Request
import com.example.retrofit_rx_recyclerview.retrofit.ServiceBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ArticlesPresenter(var stateViewArticles: ArticlesContract.View) : ArticlesContract.Presenter {

    override fun callApi(page : Int) {
        val rqt=LoadCategoryWithPost2Request(categoryType = 1,language = 1,page=page,pageSize = 10)
        ServiceBuilder.instance.getApiService().loadCategoryWithPost2(rqt)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoadCategoryWithPost2Response> {
                override fun onSubscribe(d: Disposable?) {
                }
                override fun onNext(t: LoadCategoryWithPost2Response?) {
                    if (t != null) {
                        stateViewArticles.onCompleteArticle(t)
                    }else{
                        stateViewArticles.onFailArticle("null")
                    }
                }

                override fun onError(e: Throwable?) {
                }

                override fun onComplete() {
                    stateViewArticles.onShowProgressBar()
                }

            })
    }

}