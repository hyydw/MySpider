package com.ydw.myspider

import android.app.Activity
import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.ydw.myspider.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Administrator on 2018/3/17 0017.
 */
class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.create()
                .inject(this)
    }
}