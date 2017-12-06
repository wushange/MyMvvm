package com.connxun.morui.viewmodel;

import android.databinding.Bindable;
import android.view.View;

import com.connxun.morui.BR;
import com.connxun.morui.model.entity.User;
import com.connxun.morui.model.repository.UserRepository;
import com.connxun.morui.viewmodel.helper.BaseViewModel;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wushange
 * @date 2017/12/6
 */

public class LoginViewModel extends BaseViewModel {
    UserRepository userRepository;
    private String userName;
    private String userPassWord;

    @Inject
    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
        notifyPropertyChanged(BR.userPassWord);
    }

    public void loginTest(View view) {
        Logger.e("界面上点击了登录" + userName);
        setUserName("哈哈哈变了把蒙蔽了把");
        userRepository.login(userName, userPassWord).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public Single<User> login() {
        return userRepository.login(userName, userPassWord).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

}
