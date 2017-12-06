package com.connxun.morui.model.remote.api;

import com.connxun.morui.model.entity.User;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author wushange
 * @date 2017/12/5
 */

public interface UserService {

    @FormUrlEncoded
    @POST("oauthToken/getToken.do")
    Single<User> login(@Field("userName") String userName,
                          @Field("password") String password);
}
