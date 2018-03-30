package com.ydw.myspider.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.ydw.base.ext.compat
import com.ydw.myspider.R
import kotlinx.android.synthetic.main.layout_first_activity.*
import com.viewpagerindicator.TabPageIndicator
import com.ydw.myspider.ui.fragment.FirstFragment
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Created by Administrator on 2018/3/19 0019.
 */
class FirstActivity :ImmersionBaseActivity(){
    private lateinit var centerView:View
    private lateinit var indicatorViewPager: TabPageIndicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_first_activity)
        compat(Color.TRANSPARENT)

        var tabNames = arrayOf("主页", "消息", "发现", "我")
        var fragment:Fragment = Fragment()
        var bundle:Bundle
        bottomBarTab.setOnTabSelectListener { tabId: Int ->
            when(tabId){
                R.id.tab_favorites-> {fragment = FirstFragment()
                    bundle = Bundle()
                    bundle .putInt ("pos", 0)
                    bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[0])
                    fragment.arguments = bundle
                }
                R.id.tab_nearby-> {fragment = FirstFragment()
                    bundle = Bundle()
                    bundle .putInt ("pos", 1)
                    bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[1])
                    fragment.arguments = bundle
                }
                R.id.tab_friends-> {fragment = FirstFragment()
                    bundle = Bundle()
                    bundle .putInt ("pos", 2)
                    bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[2])
                    fragment.arguments = bundle
                }
            }
            transactionFragment(fragment)
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun getLayoutResId(): Int {
        return R.layout.layout_first_activity
    }


}