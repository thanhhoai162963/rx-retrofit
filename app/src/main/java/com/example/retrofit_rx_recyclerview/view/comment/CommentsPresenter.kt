package com.example.retrofit_rx_recyclerview.view.comment

import com.example.retrofit_rx_recyclerview.model.comments.Comments
import com.example.retrofit_rx_recyclerview.request.RequestDataComments
import com.example.retrofit_rx_recyclerview.retrofit.ServiceBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CommentsPresenter(val stateViewComment: CommentsContract.View) : CommentsContract.Presenter {

    override fun callApi(postSignature:String) {
        val requestDataComments = RequestDataComments(1,postSignature)
        ServiceBuilder.instance.getApiService().postComment(requestDataComments)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Comments>{
                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(t: Comments?) {
                    if (t != null) {
                        stateViewComment.onCompleteViewComment(comments = t)
                    }else
                        stateViewComment.onFailViewComment()
                }

                override fun onError(e: Throwable?) {
                }

                override fun onComplete() {
                    stateViewComment.onShowProgressBar()
                }
            })
    }
}