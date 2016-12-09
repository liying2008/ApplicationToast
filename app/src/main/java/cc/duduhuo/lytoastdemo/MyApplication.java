package cc.duduhuo.lytoastdemo;

import android.app.Application;

import cc.duduhuo.applicationtoast.AppToast;

/**
 * =======================================================
 * 版权：©Copyright LiYing 2015-2016. All rights reserved.
 * 作者：liying
 * 日期：2016/10/10 21:22
 * 版本：1.0
 * 描述：
 * 备注：
 * =======================================================
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化AppToast库
        AppToast.init(this);
    }
}
