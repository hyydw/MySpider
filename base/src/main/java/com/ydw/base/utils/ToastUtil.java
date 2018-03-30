package com.ydw.base.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.util.logging.LogRecord;

/**
 * Created by Administrator on 2017/12/12 0012.
 */

public class ToastUtil {
    private static Context context = null;
    private static Toast toast = null;
    private static Handler handler;

    public ToastUtil(Context context){
        ToastUtil.context=context;
        if(handler==null) handler = new Handler();
    }

    public static void showToast(Context context,String text) {
        ToastUtil.context=context;
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public static void showToast(String text) {
        if(context==null)return;
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    public static void showToastLong(String text) {
        if(context==null)return;
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        } else {
            toast.setText(text);
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.show();
    }

    public static void showToastHandler(final String text){
        if(handler==null)return;
        handler.post(new Runnable() {
            @Override
            public void run() {
                    showToast(context,text);
            }
        });
    }

}
