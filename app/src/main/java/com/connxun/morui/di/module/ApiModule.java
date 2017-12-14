package com.connxun.morui.di.module;

import com.connxun.morui.model.remote.api.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author wushange
 */
@Module
public class ApiModule {
    @Singleton
    @Provides
    UserService provideUserService(Retrofit retrofit) {
        return retrofit.create(UserService.class);
    }
}
