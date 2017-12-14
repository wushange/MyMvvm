package com.connxun.morui.lib.network;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author wushange
 * @date 2017/12/14
 */

public class AppNetManager {
    private static final HashMap<String, NetProvider>  providerMap         = new HashMap<>();
    private static final HashMap<String, Retrofit>     retrofitMap         = new HashMap<>();
    private static final HashMap<String, OkHttpClient> clientMap           = new HashMap<>();
    private static final long                          connectTimeoutMills = 10000L;
    private static final long                          readTimeoutMills    = 10000L;
    private static NetProvider commonProvider;
    public static final AppNetManager INSTANCE = new AppNetManager();


    public final Retrofit getRetrofit(String baseUrl) {
        return getRetrofit(baseUrl, null);
    }

    private Retrofit getRetrofit(String baseUrl, NetProvider provider) {
        if (empty(baseUrl)) {
            throw new IllegalStateException("baseUrl can not be null");
        }
        if (retrofitMap.get(baseUrl) != null) {
            return retrofitMap.get(baseUrl);
        }

        if (provider == null) {
            provider = providerMap.get(baseUrl);
            if (provider == null) {
                provider = commonProvider;
            }
        }
        checkProvider(provider);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getClient(baseUrl, provider))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoRuiGsonConverterFactory.create())
                .build();
        retrofitMap.put(baseUrl, retrofit);
        providerMap.put(baseUrl, provider);
        return retrofit;
    }


    private boolean empty(String baseUrl) {
        return baseUrl == null || baseUrl.isEmpty();
    }

    private OkHttpClient getClient(String baseUrl, NetProvider provider) {
        if (empty(baseUrl)) {
            throw new IllegalStateException("baseUrl can not be null");
        }
        if (clientMap.get(baseUrl) != null) {
            return clientMap.get(baseUrl);
        }
        checkProvider(provider);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(provider.configConnectTimeoutSecs() != 0L ? provider.configConnectTimeoutSecs() : connectTimeoutMills, TimeUnit.SECONDS);
        builder.readTimeout(provider.configReadTimeoutSecs() != 0L ? provider.configReadTimeoutSecs() : readTimeoutMills, TimeUnit.SECONDS);
        builder.writeTimeout(provider.configWriteTimeoutSecs() != 0L ? provider.configReadTimeoutSecs() : readTimeoutMills, TimeUnit.SECONDS);
        CookieJar cookieJar = provider.configCookie();
        if (cookieJar != null) {
            builder.cookieJar(cookieJar);
        }
        provider.configHttps(builder);
        RequestHandler handler = provider.configHandler();
        if (handler != null) {
            builder.addInterceptor(new NetInterceptor(handler));
        }

        Interceptor[] interceptors = provider.configInterceptors();
        if (!empty(interceptors)) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }

        if (provider.configLogEnable()) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        OkHttpClient client = builder.build();
        clientMap.put(baseUrl, client);
        providerMap.put(baseUrl, provider);
        return client;
    }

    private boolean empty(Interceptor[] interceptors) {
        return interceptors == null || interceptors.length == 0;
    }

    private void checkProvider(NetProvider provider) {
        if (provider == null) {
            throw new IllegalStateException("must register provider first");
        }
    }


    public Map<String, Retrofit> getRetrofitMap() {
        return retrofitMap;
    }

    public Map<String, OkHttpClient> getClientMap() {
        return clientMap;
    }

    public final Object get(String baseUrl, Class service) {
        return getRetrofit(baseUrl, null).create(service);
    }

    public final void registerProvider(NetProvider provider) {
        commonProvider = provider;
    }

    public final void registerProvider(String baseUrl, NetProvider provider) {
        providerMap.put(baseUrl, provider);
    }

    public final void clearCache() {
        retrofitMap.clear();
        clientMap.clear();
    }


}
