package com.connxun.morui.lib.network;

import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * @author wushange
 * @date 2017/12/5
 */

public interface NetProvider {
    Interceptor[] configInterceptors();

    void configHttps(OkHttpClient.Builder var1);

    CookieJar configCookie();

    RequestHandler configHandler();

    long configConnectTimeoutSecs();

    long configReadTimeoutSecs();

    long configWriteTimeoutSecs();

    boolean configLogEnable();
}
