package com.ydw.myspider.app

import java.util.ArrayList

/**
 * Created by Administrator on 2018/3/22 0022.
 */
class ConstantsImageUrl {
    // 电影栏头部的图片
    val ONE_URL_01 = "http://ojyz0c8un.bkt.clouddn.com/one_01.png"

    // 头像
    val IC_AVATAR = "http://ojyz0c8un.bkt.clouddn.com/ic_avatar.png"

    // 过渡图的图片链接
    private val TRANSITION_URL_01 = "http://ojyz0c8un.bkt.clouddn.com/b_1.jpg"
    private val TRANSITION_URL_02 = "http://ojyz0c8un.bkt.clouddn.com/b_2.jpg"
    private val TRANSITION_URL_03 = "http://ojyz0c8un.bkt.clouddn.com/b_3.jpg"
    private val TRANSITION_URL_04 = "http://ojyz0c8un.bkt.clouddn.com/b_4.jpg"
    private val TRANSITION_URL_05 = "http://ojyz0c8un.bkt.clouddn.com/b_5.jpg"
    private val TRANSITION_URL_06 = "http://ojyz0c8un.bkt.clouddn.com/b_6.jpg"
    private val TRANSITION_URL_07 = "http://ojyz0c8un.bkt.clouddn.com/b_7.jpg"
    private val TRANSITION_URL_08 = "http://ojyz0c8un.bkt.clouddn.com/b_8.jpg"
    private val TRANSITION_URL_09 = "http://ojyz0c8un.bkt.clouddn.com/b_9.jpg"
    private val TRANSITION_URL_10 = "http://ojyz0c8un.bkt.clouddn.com/b_10.jpg"
    val TRANSITION_URLS = arrayOf(TRANSITION_URL_01, TRANSITION_URL_02, TRANSITION_URL_03,
            TRANSITION_URL_04, TRANSITION_URL_05, TRANSITION_URL_06, TRANSITION_URL_07,
            TRANSITION_URL_08, TRANSITION_URL_09, TRANSITION_URL_10)

    // 2张图的随机图
    private val HOME_TWO_01 = "http://ojyz0c8un.bkt.clouddn.com/home_two_01.png"
    private val HOME_TWO_02 = "http://ojyz0c8un.bkt.clouddn.com/home_two_02.png"
    private val HOME_TWO_03 = "http://ojyz0c8un.bkt.clouddn.com/home_two_03.png"
    private val HOME_TWO_04 = "http://ojyz0c8un.bkt.clouddn.com/home_two_04.png"
    private val HOME_TWO_05 = "http://ojyz0c8un.bkt.clouddn.com/home_two_05.png"
    private val HOME_TWO_06 = "http://ojyz0c8un.bkt.clouddn.com/home_two_06.png"
    private val HOME_TWO_07 = "http://ojyz0c8un.bkt.clouddn.com/home_two_07.png"
    private val HOME_TWO_08 = "http://ojyz0c8un.bkt.clouddn.com/home_two_08.png"
    private val HOME_TWO_09 = "http://ojyz0c8un.bkt.clouddn.com/home_two_09.png"
    val HOME_TWO_URLS = arrayOf(HOME_TWO_01, HOME_TWO_02, HOME_TWO_03, HOME_TWO_04, HOME_TWO_05,
            HOME_TWO_06, HOME_TWO_07, HOME_TWO_08, HOME_TWO_09)

    /**
     * 一张图的随机图
     */
    private val HOME_ONE_1 = "http://ojyz0c8un.bkt.clouddn.com/home_one_1.png"

    private var oneList: ArrayList<String>? = null

    private fun getOneUrl(): ArrayList<String> {
        //        DebugUtil.error("oneList == null:   " + (oneList == null));
        if (oneList == null) {
            oneList = ArrayList()
            synchronized(this.oneList!!) {
                if (oneList == null) {
                    for (i in 1..12) {
                        oneList!!.add("http://ojyz0c8un.bkt.clouddn.com/home_one_$i.png")
                    }
                    return oneList as ArrayList<String>
                }
            }
        }
        return oneList as ArrayList<String>
    }

    // 一张图的随机图
//    val HOME_ONE_URLS = arrayOf(getOneUrl()[0], getOneUrl()[1], getOneUrl()[2], getOneUrl()[3],
//            getOneUrl()[4], getOneUrl()[5], getOneUrl()[6], getOneUrl()[7], getOneUrl()[8],
//            getOneUrl()[9], getOneUrl()[10], getOneUrl()[11])


    //-----------------------------------------------------------------------------
    // 1 -- 23
    private val HOME_SIX_1 = "http://ojyz0c8un.bkt.clouddn.com/home_six_1.png"
    private var sixList: ArrayList<String>? = null

    private fun getSixUrl(): ArrayList<String> {
        //        DebugUtil.error("sixList == null:   " + (sixList == null));
        if (sixList == null) {
            sixList = ArrayList()
            synchronized(this.oneList!!) {
                if (sixList == null) {
                    for (i in 1..23) {
                        sixList!!.add("http://ojyz0c8un.bkt.clouddn.com/home_six_$i.png")
                    }
                    return sixList as ArrayList<String>
                }
            }
        }
        return sixList as ArrayList<String>
    }

    // 六图的随机图
//    val HOME_SIX_URLS = arrayOf(getSixUrl()[0], getSixUrl()[1], getSixUrl()[2], getSixUrl()[3],
//            getSixUrl()[4], getSixUrl()[5], getSixUrl()[6], getSixUrl()[7], getSixUrl()[8],
//            getSixUrl()[9], getSixUrl()[10], getSixUrl()[11], getSixUrl()[12], getSixUrl()[13],
//            getSixUrl()[14], getSixUrl()[15], getSixUrl()[16], getSixUrl()[17], getSixUrl()[18],
//            getSixUrl()[19], getSixUrl()[20], getSixUrl()[21], getSixUrl()[22])
}