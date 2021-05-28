package com.example.retrofit_rx_recyclerview.view.comment

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_rx_recyclerview.R
import com.example.retrofit_rx_recyclerview.adapter.CommentAdapter
import com.example.retrofit_rx_recyclerview.custom_view.MyToolBar
import com.example.retrofit_rx_recyclerview.model.comments.Comments
import com.example.retrofit_rx_recyclerview.model.comments.ListComments
import com.example.retrofit_rx_recyclerview.request.RequestDataComments
import com.example.retrofit_rx_recyclerview.retrofit.ServiceBuilder
import com.example.retrofit_rx_recyclerview.ultil.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_comments.*
import kotlinx.android.synthetic.main.item_comments.*

import java.util.*

class CommentsActivity : AppCompatActivity(), CommentsContract.View {
    var mAdapter: CommentAdapter? = null
    var mCommentsPresenter: CommentsPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)
        val signature = intent.getStringExtra(Constant.POST_SIGNATURE2)

        initCommentPresenter()

        if (signature != null) {
            mCommentsPresenter?.callApi(signature)
        }

        toolbar_comment.setToolbarListener(object : MyToolBar.ToolbarClick {
            override fun clickBack() {
                finish()
            }
        })
    }


    private fun initCommentPresenter() {
        mCommentsPresenter = CommentsPresenter(this)

    }

    private fun setAdapter(listComments: List<ListComments>?) {
        val mLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mAdapter = CommentAdapter(listComments, this)
        recyclerviewComments.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter

        }
    }

    override fun onCompleteViewComment(comments: Comments) {
        setAdapter(comments.data?.listComments)
    }

    override fun onFailViewComment() {
    }

    override fun onShowProgressBar() {
    }

}