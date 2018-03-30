package com.ydw.myspider.di.module

import android.app.Activity
import com.ydw.myspider.di.subComponent.MainSubComponent
import com.ydw.myspider.ui.activity.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by Administrator on 2018/3/17 0017.
 */
@Module
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bind(builder: MainSubComponent.Builder): AndroidInjector.Factory<out Activity>
}