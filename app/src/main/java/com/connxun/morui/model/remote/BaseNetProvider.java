package com.connxun.morui.model.remote;

import android.content.Context;

import com.connxun.morui.BuildConfig;
import com.connxun.morui.lib.network.NetProvider;
import com.connxun.morui.lib.network.RequestHandler;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.io.IOException;
import java.util.UUID;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 基础网路配置
 *
 * @author wushange
 * @date 2017/12/5
 */

public class BaseNetProvider implements NetProvider {
    private final Context mContext;
    private static final long CONNECT_TIME_OUT = 20L;
    private static final long READ_TIME_OUT    = 30L;
    private static final long WRITE_TIME_OUT   = 30L;

    @Override
    public Interceptor[] configInterceptors() {
        return null;
    }

    @Override
    public void configHttps(OkHttpClient.Builder var1) {

    }

    @Override
    public CookieJar configCookie() {
        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(this.mContext));
    }

    @Override
    public RequestHandler configHandler() {
        return new HeaderHandler();
    }

    @Override
    public long configConnectTimeoutSecs() {
        return CONNECT_TIME_OUT;
    }

    @Override
    public long configReadTimeoutSecs() {
        return READ_TIME_OUT;
    }

    @Override
    public long configWriteTimeoutSecs() {
        return WRITE_TIME_OUT;
    }

    @Override
    public boolean configLogEnable() {
        return BuildConfig.DEBUG;
    }

    private final String getTraceId() {
        return UUID.randomUUID().toString();
    }

    public BaseNetProvider(Context mContext) {
        super();
        this.mContext = mContext;
    }

    public class HeaderHandler implements RequestHandler {
        @Override
        public Request onBeforeRequest(Request request, Interceptor.Chain chain) {
            return request;
        }

        @Override
        public Response onAfterRequest(Response response, Interceptor.Chain chain) throws IOException {
            return response;
        }
    }

}
