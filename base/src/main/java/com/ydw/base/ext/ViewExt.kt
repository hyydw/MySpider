package com.ydw.base.ext

import android.view.View
import android.support.design.widget.Snackbar
/**
 * Created by Administrator on 2018/3/17 0017.
 */
fun View.showSnackbar(msgId: Int, length: Int) {
    showSnackbar(context.getString(msgId), length)
}

fun View.showSnackbar(msg: String, length: Int) {
    showSnackbar(msg, length, null, {})
}

fun View.showSnackbar(msgId: Int, length: Int, actionMessageId: Int, action: (View) -> Unit) {
    showSnackbar(context.getString(msgId), length, context.getString(actionMessageId), action)
}

fun View.showSnackbar(msg: String,length: Int,actionMessage: CharSequence?,action: (View) -> Unit) {
    val snackbar = Snackbar.make(this, msg, length)
    if (actionMessage != null) {
        snackbar.setAction(actionMessage) {
            action(this)
        }.show()
    }
}