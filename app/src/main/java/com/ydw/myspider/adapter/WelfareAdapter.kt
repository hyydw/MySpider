package com.ydw.myspider.adapter

import android.graphics.drawable.Drawable
import android.widget.FrameLayout
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ydw.base.bean.GankIoDataBean
import com.ydw.base.bean.ResultBean
import com.ydw.myspider.R
import org.jetbrains.anko.displayMetrics
import java.net.URL

/**
 * Created by Administrator on 2018/3/26 0026.
 */
class WelfareAdapter(layoutResId: Int) : BaseQuickAdapter<ResultBean, BaseViewHolder>(layoutResId) {
    override fun convert(helper: BaseViewHolder?, item: ResultBean?) {
        val img:ImageView = helper!!.getView(R.id.imageView_welfare)
        val w=mContext.displayMetrics.widthPixels
        val lp= FrameLayout.LayoutParams(w/2,w/2)
        img.layoutParams = lp
        val options = RequestOptions()
                .placeholder(R.mipmap.bg)
                .error(R.drawable.p2)
                .override(w/2,w/2)
        Glide.with(mContext)
                .load(item?.url)
                .apply(options)
                .into(img)
//        Glide.with(mContext).load("https://ws1.sinaimg.cn/large/610dc034ly1fjs25xfq48j20u00mhtb6.jpg").into(helper?.getView(R.id.imageView_welfare))
//        Glide.with(mContext).load(R.mipmap.bg).into(helper?.getView(R.id.imageView_welfare))
//        helper?.getView<ImageView>(R.id.imageView_welfare)!!.setImageResource(R.mipmap.bg)
    }

    fun setData(list: List<ResultBean>){
        setNewData(list)
    }
}

