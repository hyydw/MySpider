package com.ydw.myspider.di.module

import android.content.Context
import com.ydw.myspider.App
import com.ydw.myspider.di.subComponent.MainSubComponent
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2018/3/17 0017.
 */
@Module(subcomponents = arrayOf(MainSubComponent::class))
class AppModule {
    @Provides
    fun contextProvider(application: App): Context {
        return application.applicationContext
    }
}