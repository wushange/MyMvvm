package com.connxun.morui.lib.network;

import com.connxun.morui.model.remote.exception.ApiException;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wushange
 * @date 2017/12/5
 */

public interface RequestHandler {

    /**
     * 请求头处理
     *
     * @param request
     * @param chain
     * @return
     */
    Request onBeforeRequest(Request request, Interceptor.Chain chain);

    /**
     * 响应处理
     *
     * @param response
     * @param chain
     * @return
     * @throws IOException
     * @throws ApiException
     */
    Response onAfterRequest(Response response, Interceptor.Chain chain) throws IOException;
}
