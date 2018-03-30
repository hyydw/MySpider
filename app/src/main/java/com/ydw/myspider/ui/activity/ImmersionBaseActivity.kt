package com.ydw.myspider.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.*
import com.ydw.myspider.R
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN



/**
 * Created by Administrator on 2018/3/19 0019.
 */
abstract class ImmersionBaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(getLayoutResId())//把设置布局文件的操作交给继承的子类

        val parentView = findViewById<ViewGroup>(Window.ID_ANDROID_CONTENT).getChildAt(0)
//        if (parentView != null ) {
            parentView.fitsSystemWindows = true
//        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.navigationBarColor = getColor(R.color.colorTheme)
            window.statusBarColor = getColor(R.color.colorTheme)
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            val intent = Intent(Intent.ACTION_MAIN)//主启动，不期望接收数据
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK //新的activity栈中开启，或者已经存在就调到栈前
            intent.addCategory(Intent.CATEGORY_HOME)//添加种类，为设备首次启动显示的页面
            startActivity(intent)
        }
        return super.onKeyDown(keyCode, event)
    }

    protected fun getNavigationBarHeight():Int {

        val hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey()
        val hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK)
        return if (!hasMenuKey && !hasBackKey) {
            val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
            //获取NavigationBar的高度
            val height = resources.getDimensionPixelSize(resourceId)
            height
        }
        else{
            0
        }
    }

    /**
     * 返回当前Activity布局文件的id
     *
     * @return
     */
    protected abstract fun getLayoutResId(): Int

    protected fun transactionFragment(fragment:Fragment?){
        if(fragment==null)return
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.contentContainer,fragment).commit()
    }
}