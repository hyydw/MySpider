package com.ydw.myspider.http;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Subscription;

/**
 * Created by jingbin on 2017/1/17.
 * 用于数据请求的回调
 */

public interface RequestImpl {
    void loadSuccess(Object object);

    void loadFailed();

    void addSubscription(Subscription subscription);
}
