package com.ydw.myspider.di.module

import com.ydw.myspider.model.MainModel
import com.ydw.myspider.view.activity.MainActivity
import com.ydw.myspider.view.activity.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/3/17 0017.
 */
@Module
class MainPresenterModule {
    @Provides
    fun modelProvider():MainModel{
        return MainModel()
    }

    @Provides
    fun viewProvider(activity: MainActivity): MainView {
        return activity
    }
}