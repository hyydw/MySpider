package com.ydw.base.bean

import android.os.Parcel
import android.os.Parcelable
import com.ydw.base.utils.http.ParamNames
import java.io.Serializable

/**
 * Created by Administrator on 2018/3/26 0026.
 */
data class GankIoDataBean (@ParamNames("error") var error:Boolean,
                           @ParamNames("results") var results:List<ResultBean>)

data class ResultBean(@ParamNames("_id") var _id:String,
                      @ParamNames("createdAt") var createdAt:String,
                      @ParamNames("desc") var desc:String,
                      @ParamNames("publishedAt") var publishedAt:String,
                      @ParamNames("source") var source:String,
                      @ParamNames("type") var type:String,
                      @ParamNames("url") var url:String,
                      @ParamNames("used") var used:Boolean,
                      @ParamNames("who") var who:String,
                      @ParamNames("images") var images:List<String>):Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.createStringArrayList()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(createdAt)
        parcel.writeString(desc)
        parcel.writeString(publishedAt)
        parcel.writeString(source)
        parcel.writeString(type)
        parcel.writeString(url)
        parcel.writeByte(if (used) 1 else 0)
        parcel.writeString(who)
        parcel.writeStringList(images)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultBean> {
        override fun createFromParcel(parcel: Parcel): ResultBean {
            return ResultBean(parcel)
        }

        override fun newArray(size: Int): Array<ResultBean?> {
            return arrayOfNulls(size)
        }
    }
}