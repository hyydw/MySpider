package com.ydw.myspider.ui.activity

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import android.support.v4.app.DialogFragment
import com.ydw.myspider.R
import com.ydw.myspider.presenter.MainPresenter
import dagger.android.AndroidInjection
import javax.inject.Inject
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import com.ydw.base.ext.*
import com.ydw.myspider.ui.fragment.FirstFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.ydw.myspider.adapter.HomepageContentAdapter
import com.ydw.myspider.ui.fragment.HomepageFragment
import kotlinx.android.synthetic.main.fragment_page_photos.*
import java.lang.reflect.ParameterizedType
import java.util.*


class MainActivity :ImmersionBaseActivity() , MainView{
    val tabNames = arrayOf("主页", "消息", "发现", "我的")
    private var fragments:Array<Fragment> ?= null
    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    @Inject
    lateinit var presenter: MainPresenter

    override fun onSaveInstanceState(outState: Bundle?) {
        supportFragmentManager.putFragment(outState,tabNames[0],fragments!![0])
        supportFragmentManager.putFragment(outState,tabNames[1],fragments!![1])
        supportFragmentManager.putFragment(outState,tabNames[2],fragments!![2])
        supportFragmentManager.putFragment(outState,tabNames[3],fragments!![3])
//        outState?.putParcelable(FRAGMENT,)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compat(resources.getColor(R.color.colorTheme))
        if(savedInstanceState==null) {
            initFragment()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val fragment1=supportFragmentManager.getFragment(savedInstanceState,tabNames[0])
        val fragment2=supportFragmentManager.getFragment(savedInstanceState,tabNames[1])
        val fragment3=supportFragmentManager.getFragment(savedInstanceState,tabNames[2])
        val fragment4=supportFragmentManager.getFragment(savedInstanceState,tabNames[3])
        fragments = arrayOf(fragment1,fragment2,fragment3,fragment4)

    }

    override fun onResume() {
        super.onResume()
        presenter.resume()
        initListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    private fun initFragment(){
        if(fragments==null) {
            fragments = arrayOf(HomepageFragment(), FirstFragment(), FirstFragment(), FirstFragment())
            supportFragmentManager.beginTransaction()
                    .add(R.id.contentContainer, fragments!![0], tabNames[0])
                    .hide(fragments!![0])
                    .add(R.id.contentContainer, fragments!![1], tabNames[1])
                    .hide(fragments!![1])
                    .add(R.id.contentContainer, fragments!![2], tabNames[2])
                    .hide(fragments!![2])
                    .add(R.id.contentContainer, fragments!![3], tabNames[3])
                    .hide(fragments!![3])
                    .commit()
        }
    }

    private fun initListener(){
        if(fragments==null)return
        var bundle:Bundle
        bottomBarTab.setOnTabSelectListener { tabId: Int ->
            when(tabId){
                R.id.home_page1-> {
                    supportFragmentManager.beginTransaction()
                            .show(fragments!![0])
                            .hide(fragments!![1])
                            .hide(fragments!![2])
                            .hide(fragments!![3])
                            .commit()
                }
                R.id.home_page2-> {
                    bundle = Bundle()
                    bundle .putInt ("pos", 1)
                    bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[1])
                    fragments!![1].arguments = bundle
                    supportFragmentManager.beginTransaction()
                            .hide(fragments!![0])
                            .show(fragments!![1])
                            .hide(fragments!![2])
                            .hide(fragments!![3])
                            .commit()
                }
                R.id.home_page3-> {
                    bundle = Bundle()
                    bundle .putInt ("pos", 2)
                    bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[2])
                    fragments!![2].arguments = bundle
                    supportFragmentManager.beginTransaction()
                            .hide(fragments!![0])
                            .hide(fragments!![1])
                            .show(fragments!![2])
                            .hide(fragments!![3])
                            .commit()
                }
                R.id.home_page4-> {
                    bundle = Bundle()
                    bundle .putInt ("pos", 3)
                    bundle.putString(FirstFragment.INTENT_STRING_TABNAME, tabNames[3])
                    fragments!![3].arguments = bundle
                    supportFragmentManager.beginTransaction()
                            .hide(fragments!![0])
                            .hide(fragments!![1])
                            .hide(fragments!![2])
                            .show(fragments!![3])
                            .commit()
                }
            }

        }
    }
}


