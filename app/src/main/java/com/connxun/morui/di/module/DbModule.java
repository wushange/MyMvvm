package com.connxun.morui.di.module;

import android.content.Context;

import com.connxun.morui.model.local.BaseAppData;
import com.connxun.morui.model.local.dao.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author wushange
 * @date 2017/12/14
 */

@Module
public class DbModule {

    @Provides
    @Singleton
    UserDao provideUserDao(Context context) {
        return BaseAppData.getInstance(context).userDao();
    }

}
