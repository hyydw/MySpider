package com.ydw.myspider

import android.app.Activity
import android.app.Application
import android.support.v7.app.AppCompatActivity
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.ydw.base.utils.DebugUtil
import com.ydw.base.utils.http.HttpUtils
import com.ydw.myspider.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by Administrator on 2018/3/17 0017.
 */
class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    companion object {
        var instance:App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        DaggerAppComponent.create()
                .inject(this)
        Logger.addLogAdapter(AndroidLogAdapter())
        HttpUtils.getInstance().init(this, DebugUtil.DEBUG)
    }
}