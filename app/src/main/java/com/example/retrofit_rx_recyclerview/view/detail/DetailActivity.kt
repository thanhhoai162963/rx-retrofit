package com.example.retrofit_rx_recyclerview.view.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofit_rx_recyclerview.R
import com.example.retrofit_rx_recyclerview.model.detail.Detail
import com.example.retrofit_rx_recyclerview.ultil.Constant
import com.example.retrofit_rx_recyclerview.view.comment.CommentsActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailContract.View {
    private var mPostSig: String? = null
    private var mDetailPresenter: DetailPresenter? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        mDetailPresenter =  DetailPresenter(this)

        getDataFromIntent()
        progressBar_center_detail.visibility = View.VISIBLE
        buttonComment.visibility = View.GONE
        setListener()
    }

    private fun getDataFromIntent() {
        val intent = intent
        mPostSig = intent.getStringExtra(Constant.POST_SIGNATURE)
        mPostSig?.let { mDetailPresenter?.callApi(it) }
    }


    private fun setDataWebView(uri: String) {
        val encodedHtml = Base64.encodeToString(uri.toByteArray(), Base64.NO_PADDING)
        web_view.loadData(encodedHtml, "text/html", "base64")
    }


    private fun setListener() {
        buttonComment.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent1 = Intent(this@DetailActivity, CommentsActivity::class.java)
                intent1.putExtra(Constant.POST_SIGNATURE2, mPostSig)
                startActivity(intent1)
            }

        })
    }

    override fun onCompleteDetail(detail: Detail) {
        detail.data?.msg?.msgContent?.let { setDataWebView(it) }
    }

    override fun onFailDetail() {
    }

    override fun onShowProgressBar() {
        progressBar_center_detail.visibility = View.GONE
        buttonComment.visibility = View.VISIBLE
    }

}


