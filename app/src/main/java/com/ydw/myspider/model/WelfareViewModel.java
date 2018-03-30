package com.ydw.myspider.model;

import android.arch.lifecycle.ViewModel;


import com.ydw.base.bean.GankIoDataBean;
import com.ydw.base.bean.ResultBean;
import com.ydw.base.utils.http.HttpUtils;
import com.ydw.myspider.adapter.WelfareAdapter;
import com.ydw.myspider.http.RequestImpl;
import com.ydw.myspider.ui.fragment.WelfareFragment;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * @author jingbin
 * @data 2018/1/17
 * @Description 福利页面ViewModel
 */

public class WelfareViewModel extends ViewModel {

//    private final WelfareFragment activity;
    private final GankOtherModel mModel;
    private WelfareAdapter adapter;
//    private final ACache mACache;
//    private WelfareNavigator navigator;
    private int mPage = 1;
    private ArrayList<String> imgList = new ArrayList<>();
    private ArrayList<String> imageTitleList = new ArrayList<>();
    private List<ResultBean> results = new ArrayList<>();

//    public void setNavigator(WelfareNavigator navigator) {
//        this.navigator = navigator;
//    }
//
//    public void onDestroy() {
//        navigator = null;
//    }

    public ArrayList<String> getImgList(){return imgList;}
    public ArrayList<String> getImageTitleList(){return imageTitleList;}

    public WelfareViewModel(WelfareAdapter adapter) {
//        this.activity = activity;
        this.adapter = adapter;
        mModel = new GankOtherModel();
//        mACache = ACache.get(CloudReaderApplication.getInstance());
    }

    public void loadWelfareData(){
        mModel.setData("福利", mPage, HttpUtils.per_page_more);
        mModel.getGankIoData(new RequestImpl() {
            @Override
            public void loadSuccess(Object object) {
//                navigator.showLoadSuccessView();

                GankIoDataBean gankIoDataBean = (GankIoDataBean) object;
                if (mPage == 1) {
                    if (gankIoDataBean != null
                            && gankIoDataBean.getResults() != null
                            && gankIoDataBean.getResults().size() > 0) {
                        imgList.clear();
                        for (int i = 0; i < gankIoDataBean.getResults().size(); i++) {
                            imgList.add(gankIoDataBean.getResults().get(i).getUrl());
                            imageTitleList.add(gankIoDataBean.getResults().get(i).getDesc());
                        }
                        adapter.setData(gankIoDataBean.getResults());
//                        results.addAll(gankIoDataBean.getResults());
//                        navigator.setImageList(imgList,imageTitleList);
//                        navigator.showAdapterView(gankIoDataBean);

                    } else {
//                        navigator.showLoadFailedView();
                    }
                } else {
                    if (gankIoDataBean != null && gankIoDataBean.getResults() != null && gankIoDataBean.getResults().size() > 0) {
//                        navigator.refreshAdapter(gankIoDataBean);
                        for (int i = 0; i < gankIoDataBean.getResults().size(); i++) {
                            imgList.add(gankIoDataBean.getResults().get(i).getUrl());
                            imageTitleList.add(gankIoDataBean.getResults().get(i).getDesc());
                        }
                        adapter.addData(gankIoDataBean.getResults());
                        adapter.loadMoreComplete();
//                        results.addAll(gankIoDataBean.getResults());
//                        adapter.setData(results);
//                        navigator.setImageList(imgList,imageTitleList);
                    } else {
//                        navigator.showListNoMoreLoading();
                    }
                }
            }

            @Override
            public void loadFailed() {
//                navigator.showLoadFailedView();
                if (mPage > 1) {
                    mPage--;
                }
            }

            @Override
            public void addSubscription(Subscription subscription) {
//                activity.addSubscription(subscription);
            }
        });
    }

    public int getPage() {
        return mPage;
    }

    public void setPage(int mPage) {
        this.mPage = mPage;
    }
}
