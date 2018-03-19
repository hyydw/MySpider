package com.ydw.myspider.presenter

import com.ydw.myspider.model.MainModel
import com.ydw.myspider.view.activity.MainView
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/17 0017.
 */
class MainPresenter @Inject constructor(var model: MainModel?, var mainView:MainView?){


    fun onCreat(){

    }

    fun resume(){

    }

    fun destroy(){
        model=null
        mainView=null
    }
}