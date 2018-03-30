package com.ydw.myspider.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by Administrator on 2018/3/26 0026.
 */
class HomepageContentAdapter(fm:FragmentManager, private var list: Array<Fragment>) : FragmentPagerAdapter(fm) {

    private val titles = arrayOf("安卓","福利","干货")

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment = list[position]

    override fun getPageTitle(position: Int): CharSequence = titles[position]

}