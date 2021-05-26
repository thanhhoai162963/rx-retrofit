package com.example.retrofit_rx_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.retrofit_rx_recyclerview.adapter.MedicineAdapter
import com.example.retrofit_rx_recyclerview.model.list.Base
import com.example.retrofit_rx_recyclerview.model.list.CategorySub
import com.example.retrofit_rx_recyclerview.request.RequestDataList

import com.example.retrofit_rx_recyclerview.retrofit.ServiceBuilder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val requestData = RequestDataList(categoryType = 1,language = 1,page = 1,pageSize = 10)
        test.setOnClickListener {
            callApi(requestData)
            test.visibility = View.GONE
        }

    }
    fun callApi(requestDataList: RequestDataList){
        ServiceBuilder.instance.getApiService().post(requestDataList)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Base> {
                override fun onSubscribe(d: Disposable?) {
                    Toast.makeText(this@MainActivity,"ket noi",Toast.LENGTH_LONG).show()
                    Log.d("bbb","not connect")
                }

                override fun onNext(t: Base?) {
                    Log.d("bbb", t?.data?.list?.get(0)?.list?.get(1)?.title.toString())
                    recyclerviewBuilder(t?.data?.list?.get(0)?.list)
                }

                override fun onError(e: Throwable?) {
                    Toast.makeText(this@MainActivity,"loi",Toast.LENGTH_LONG).show()
                }

                override fun onComplete() {
                }
            })
            
    }


    fun recyclerviewBuilder(listCategorySub:  List<CategorySub>?){
        listCategorySub?.let {
            val medicineAdapter = MedicineAdapter()
            medicineAdapter.setData(it,this)
            recyclerview.apply {
                setItemViewCacheSize(20)
                addItemDecoration(DividerItemDecoration(this@MainActivity,DividerItemDecoration.VERTICAL))
                adapter = medicineAdapter
            }
        }

    }

}



