package com.example.retrofit_rx_recyclerview.view.articles

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit_rx_recyclerview.R
import com.example.retrofit_rx_recyclerview.adapter.MedicineAdapter
import com.example.retrofit_rx_recyclerview.model.list.LoadCategoryWithPost2Response
import com.example.retrofit_rx_recyclerview.model.list.CategorySub
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class ArticlesActivity : AppCompatActivity(), ArticlesContract.View {

    private var mAdapter: MedicineAdapter? = null
    private var mAriclesPresenter: ArticlesPresenter? = null
    private var mPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initPresenter()
        setListener()

    }

    private fun initPresenter() {
        mAriclesPresenter = ArticlesPresenter(this)
    }


    private fun setListener() {
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.layoutManager = mLayoutManager
        button_test.setOnClickListener {
            mAriclesPresenter?.callApi(mPage)
            button_test.visibility = View.GONE
            progressBar_center.visibility = View.VISIBLE
        }
        var loading = true
        var firstVisibleItemPosition: Int
        var visibleItemCount: Int
        var totalItemCount: Int
        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) {
                    visibleItemCount = mLayoutManager.childCount
                    totalItemCount = mLayoutManager.itemCount
                    firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition()
                    if (loading) {
                        if (visibleItemCount + firstVisibleItemPosition >= totalItemCount) {
                            loading = true
                            progressBar_bottom.visibility = View.VISIBLE
                            for (item in 0..4) {
                                mAriclesPresenter?.callApi(mPage)
                            }
                        }
                    }
                }
            }
        })
    }

    override fun onCompleteArticle(base: LoadCategoryWithPost2Response) {
        setAdapter(base.data?.list?.get(0)?.list)
    }

    override fun onFailArticle(msg: String) {
    }

    override fun onShowProgressBar() {
        progressBar_center.visibility = View.GONE
    }


    private fun setAdapter(data: List<CategorySub>?) {
        if (mAdapter == null) {
            mAdapter = MedicineAdapter()
            data?.let { mAdapter!!.setData(it, this) }
            recyclerview.apply {
                adapter = mAdapter
                addItemDecoration(
                    DividerItemDecoration(
                        this@ArticlesActivity,
                        DividerItemDecoration.VERTICAL
                    )
                )
            }
        } else {
            data?.let { mAdapter?.addData(it) }
            Observable.timer(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    progressBar_bottom.visibility = View.GONE
                }
        }
    }
}



