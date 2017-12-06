package com.connxun.morui.model.repository;

import com.connxun.morui.model.entity.User;
import com.connxun.morui.model.remote.api.UserService;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * @author wushange
 * @date 2017/12/5
 */

public class UserRepository {

    UserService service;

    @Inject
    public UserRepository(UserService service) {
        this.service = service;
    }

    public  Single<User> login(String userName, String pwd) {
        return service.login(userName, pwd);
    }
}
