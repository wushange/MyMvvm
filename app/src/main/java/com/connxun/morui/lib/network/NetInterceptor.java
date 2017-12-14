package com.connxun.morui.lib.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wushange
 * @date 2017/12/5
 */
public class NetInterceptor implements Interceptor {
    private RequestHandler requestHandler;

    public NetInterceptor(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (requestHandler != null) {
            request = requestHandler.onBeforeRequest(request, chain);
        }
        Response response = chain.proceed(request);
        if (requestHandler != null) {
            response = requestHandler.onAfterRequest(response, chain);
        }
        return response;
    }
}
