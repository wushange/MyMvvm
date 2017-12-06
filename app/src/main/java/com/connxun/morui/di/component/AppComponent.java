package com.connxun.morui.di.component;

import com.connxun.morui.MyApplication;
import com.connxun.morui.di.module.ActivityModule;
import com.connxun.morui.di.module.ApiModule;
import com.connxun.morui.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author wushange
 * @date 2017/12/4
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    void inject(MyApplication myApplication);

    ActivityComponent plus(ActivityModule activityModule);
}
