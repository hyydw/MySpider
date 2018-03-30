package com.ydw.myspider.ui.fragment

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ydw.base.bean.ResultBean
import com.ydw.base.utils.http.HttpUtils
import com.ydw.myspider.R
import com.ydw.myspider.adapter.WelfareAdapter
import com.ydw.myspider.http.HttpClient
import com.ydw.myspider.http.RequestImpl
import com.ydw.myspider.model.GankOtherModel
import com.ydw.myspider.model.WelfareViewModel
import com.ydw.myspider.ui.activity.ViewBigImageActivity
import org.jetbrains.anko.doAsync
import java.util.ArrayList

/**
 * Created by Administrator on 2018/3/26 0026.
 */
class WelfareFragment : Fragment() {
    private lateinit var recyclerview: RecyclerView
    private var mRecyclerViewState: Parcelable? = null
    private var mAdapter: WelfareAdapter ?= null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = layoutInflater.inflate(R.layout.fragment_welfare,container,false)
        initView(v)

        return v
    }
    private fun initView(v: View){
        mAdapter = WelfareAdapter(R.layout.item_welfare_rv).apply {
            openLoadAnimation(BaseQuickAdapter.SCALEIN)
            setEnableLoadMore(true)
            isFirstOnly(false)
        }
        recyclerview = v.findViewById<RecyclerView>(R.id.rv_welfare).apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager (context,2)
            adapter = mAdapter
        }
        val viewModel = WelfareViewModel(mAdapter!!)
        mAdapter!!.setOnLoadMoreListener({
            viewModel.page ++
            viewModel.loadWelfareData()
        },recyclerview)
        mAdapter!!.setOnItemClickListener { adapter, view, position ->
            ViewBigImageActivity.startImageList(context, position, viewModel.imgList, viewModel.imageTitleList)
        }

        viewModel.loadWelfareData()
    }

    override fun onResume() {
        super.onResume()
        if (mRecyclerViewState != null) {
            recyclerview.layoutManager.onRestoreInstanceState(mRecyclerViewState)
            mRecyclerViewState = null
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mRecyclerViewState = recyclerview.layoutManager.onSaveInstanceState()
    }


}