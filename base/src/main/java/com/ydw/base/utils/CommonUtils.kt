package com.ydw.base.utils

import android.app.Application
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Administrator on 2018/3/22 0022.
 */
class CommonUtils {
    /**
     * 随机颜色
     */
    fun randomColor(): Int {
        val random = Random()
        val red = random.nextInt(150) + 50//50-199
        val green = random.nextInt(150) + 50//50-199
        val blue = random.nextInt(150) + 50//50-199
        return Color.rgb(red, green, blue)
    }

    /**
     * 得到年月日的"日"
     */
    private fun getDate(): String {
        val date = Date()
        val dateFm = SimpleDateFormat("dd")
        return dateFm.format(date)
    }


//    fun getDrawable(app:Application,resid: Int): Drawable {
//        return getResoure(app).getDrawable(resid)
//    }
//
//    fun getColor(app:Application,resid: Int): Int {
//        return getResoure(app).getColor(resid)
//    }

    fun getResoure(app:Application): Resources {
        return app.resources
    }

    fun getStringArray(app:Application,resid: Int): Array<String> {
        return getResoure(app).getStringArray(resid)
    }

    fun getString(app:Application,resid: Int): String {
        return getResoure(app).getString(resid)
    }

    fun getDimens(app:Application,resId: Int): Float {
        return getResoure(app).getDimension(resId)
    }

    fun removeSelfFromParent(child: View?) {

        if (child != null) {

            val parent = child.parent

            if (parent is ViewGroup) {

                parent.removeView(child)
            }
        }
    }
}