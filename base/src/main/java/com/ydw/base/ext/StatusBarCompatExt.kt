
package com.ydw.base.ext

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.app.NotificationCompat.COLOR_DEFAULT
import android.view.View
import com.ydw.base.R


/**
 * Created by Administrator on 2018/3/20 0020.
 */


fun AppCompatActivity.compat(statusColor:Int){
    val defaultColor:Int = Color.GRAY
    //当前手机版本为5.0及以上
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.statusBarColor = statusColor
        return
    }

    //当前手机版本为4.4
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        var color = defaultColor
        val contentView = findViewById<ViewGroup>(android.R.id.content)
        if (statusColor != defaultColor) {
            color = statusColor
        }
        val statusBarView = View(this)
        val lp = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(this))
        statusBarView.setBackgroundColor(color)
        contentView.addView(statusBarView, lp)
    }
}

fun AppCompatActivity.compat(){
    compat(Color.GRAY)
}

private fun getStatusBarHeight(context: Context): Int {
    var result = 0
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = context.resources.getDimensionPixelSize(resourceId)
    }
    return result
}