package com.connxun.morui.viewmodel;

import android.databinding.Bindable;

import com.connxun.morui.BR;
import com.connxun.morui.model.entity.User;
import com.connxun.morui.model.repository.UserRepository;
import com.connxun.morui.viewmodel.helper.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author wushange
 * @date 2017/12/6
 */

public class LoginViewModel extends BaseViewModel {
    private UserRepository userRepository;
    private String         userName;
    private String         userPassWord;


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


    public Single<User> login() {
        return userRepository.login(userName, userPassWord)
                .subscribeOn(Schedulers.io())
                .doOnSuccess(user -> userRepository.insertUser(user))
                .observeOn(AndroidSchedulers.mainThread());

    }

}
