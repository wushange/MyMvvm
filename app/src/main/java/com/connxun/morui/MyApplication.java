package com.connxun.morui;

import android.app.Application;

import com.connxun.morui.di.component.AppComponent;
import com.connxun.morui.di.component.DaggerAppComponent;
import com.connxun.morui.di.module.ApiModule;
import com.connxun.morui.di.module.AppModule;
import com.connxun.morui.view.helper.util.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * @author wushange
 * @date 2017/12/4
 */

public class MyApplication extends Application {
    private AppComponent mApplicationComponent;
    private static MyApplication instance = null;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
        instance = this;
        Utils.init(this);
        Logger.addLogAdapter(new AndroidLogAdapter());

    }

    public final AppComponent getComponent() {
        return mApplicationComponent;
    }

    private void initComponent() {
        mApplicationComponent =
                DaggerAppComponent.builder().appModule(new AppModule(this)).apiModule(new ApiModule()).build();
        mApplicationComponent.inject(this);
    }
}
