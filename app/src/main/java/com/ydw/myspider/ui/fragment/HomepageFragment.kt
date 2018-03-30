package com.ydw.myspider.ui.fragment

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ydw.myspider.R
import com.ydw.myspider.adapter.HomepageContentAdapter
import kotlinx.android.synthetic.main.fragment_page_photos.*

/**
 * Created by Administrator on 2018/3/20 0020.
 */
class HomepageFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = layoutInflater.inflate(R.layout.fragment_page_photos,container,false)

        initHomepage(v)
        return v
    }
    private fun initHomepage(v:View){
        val viewpager = v.findViewById<ViewPager>(R.id.homepage_content_viewpager)
        val tabs = v.findViewById<TabLayout>(R.id.homepage_tabs)
        val fragments= arrayOf(FirstFragment() as Fragment,WelfareFragment() as Fragment,FirstFragment() as Fragment)
        viewpager.adapter = HomepageContentAdapter(this.fragmentManager!!,fragments)
        viewpager.offscreenPageLimit = 3
        viewpager.currentItem = 1
        tabs.tabMode = TabLayout.MODE_FIXED
        tabs.setupWithViewPager(viewpager)
    }
}