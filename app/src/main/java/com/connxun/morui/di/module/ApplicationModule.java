package com.connxun.morui.di.module;

import android.content.Context;

import com.connxun.morui.Constants;
import com.connxun.morui.lib.network.AppNetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author wushange
 * @date 2017/12/4
 */

@Module
public class ApplicationModule {
    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context.getApplicationContext();
    }


    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return AppNetManager.INSTANCE.getRetrofit(Constants.HOST);
    }



}
