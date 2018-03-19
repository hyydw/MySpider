package com.ydw.myspider.di.subComponent

import com.ydw.myspider.di.module.MainPresenterModule
import com.ydw.myspider.view.activity.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * Created by Administrator on 2018/3/17 0017.
 */
@Subcomponent(modules = arrayOf(MainPresenterModule::class))
interface MainSubComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}