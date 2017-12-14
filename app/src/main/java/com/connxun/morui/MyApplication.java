package com.connxun.morui;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.connxun.morui.di.component.ApplicationComponent;
import com.connxun.morui.di.component.DaggerApplicationComponent;
import com.connxun.morui.di.module.ApiModule;
import com.connxun.morui.di.module.ApplicationModule;
import com.connxun.morui.di.module.DbModule;
import com.connxun.morui.lib.network.AppNetManager;
import com.connxun.morui.model.remote.BaseNetProvider;
import com.connxun.morui.view.helper.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * @author wushange
 * @date 2017/12/4
 */

public class MyApplication extends Application {
    private ApplicationComponent mApplicationComponent;
    private static MyApplication instance = null;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initComponent();
        AppNetManager.INSTANCE.registerProvider(new BaseNetProvider(this));
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());

    }

    public final ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    private void initComponent() {
        mApplicationComponent =
                DaggerApplicationComponent.builder()
                        .applicationModule(new ApplicationModule(this))
                        .apiModule(new ApiModule())
                        .dbModule(new DbModule())
                        .build();
        mApplicationComponent.inject(this);
    }
}
