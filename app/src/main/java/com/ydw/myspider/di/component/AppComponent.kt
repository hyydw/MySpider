package com.ydw.myspider.di.component

import com.ydw.myspider.App
import com.ydw.myspider.di.module.AppModule
import com.ydw.myspider.di.module.MainActivityModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Administrator on 2018/3/17 0017.
 */
@Component(modules = arrayOf(
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule::class,
        AppModule::class,
        MainActivityModule::class
))
interface AppComponent {
    fun inject(application: App)
}