package com.connxun.morui.di.module;

import android.app.Application;

import com.connxun.morui.Constants;
import com.connxun.morui.model.remote.help.BaseNetProvider;
import com.connxun.morui.model.remote.help.MoRuiGsonConverterFactory;
import com.connxun.morui.model.remote.help.NetProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author wushange
 * @date 2017/12/4
 */

@Module
public class AppModule {
    private final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public final Application provideApp() {
        return this.app;
    }

    @Provides
    @Singleton
    OkHttpClient.Builder provideOkHttpClientBuild() {
        //网络配置提供者
        NetProvider provider = new BaseNetProvider(app);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(provider.configConnectTimeoutSecs(), TimeUnit.SECONDS);
        builder.readTimeout(provider.configReadTimeoutSecs(), TimeUnit.SECONDS);
        builder.writeTimeout(provider.configWriteTimeoutSecs(), TimeUnit.SECONDS);
//        CookieJar cookieJar = provider.configCookie();
//        if (cookieJar != null) {
//            builder.cookieJar(cookieJar);
//        }
//        provider.configHttps(builder);
//        RequestHandler handler = provider.configHandler();
//        if (handler != null) {
//            builder.addInterceptor(new NetInterceptor(handler));
//        }
//        Interceptor[] interceptors = provider.configInterceptors();
//        if (interceptors != null) {
//            for (Interceptor interceptor : interceptors) {
//                builder.addInterceptor(interceptor);
//            }
//        }
//        if (provider.configLogEnable()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
//        }
        return builder;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient.Builder builder) {
        return new Retrofit.Builder()
                .baseUrl(Constants.HOST)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoRuiGsonConverterFactory.create())
                .build();
    }


}
