package com.connxun.morui.di.component;

import com.connxun.morui.MyApplication;
import com.connxun.morui.di.module.ActivityModule;
import com.connxun.morui.di.module.ApiModule;
import com.connxun.morui.di.module.ApplicationModule;
import com.connxun.morui.di.module.DbModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author wushange
 * @date 2017/12/4
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class, DbModule.class})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);

    ActivityComponent plus(ActivityModule activityModule);
}
