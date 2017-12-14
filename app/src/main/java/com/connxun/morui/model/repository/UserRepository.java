package com.connxun.morui.model.repository;

import com.connxun.morui.model.entity.User;
import com.connxun.morui.model.local.dao.UserDao;
import com.connxun.morui.model.remote.api.UserService;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * @author wushange
 * @date 2017/12/5
 */

public class UserRepository {

    private UserService userService;
    private UserDao     userDao;


    @Inject
    public UserRepository(UserService userService, UserDao userDao) {
        this.userService = userService;
        this.userDao = userDao;
    }

    public Single<User> login(String userName, String pwd) {
        return userService.login(userName, pwd);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
