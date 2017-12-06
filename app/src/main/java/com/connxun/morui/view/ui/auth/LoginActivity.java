package com.connxun.morui.view.ui.auth;

import android.view.View;

import com.connxun.morui.R;
import com.connxun.morui.model.entity.User;
import com.connxun.morui.databinding.LoginActivityBinding;
import com.connxun.morui.view.ui.base.BaseActivity;
import com.connxun.morui.viewmodel.LoginViewModel;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * @author wushange
 * @date 2017/12/6
 */

public class LoginActivity extends BaseActivity {

    @Inject
    LoginViewModel loginViewModel;

    @Override
    public void loadData() {
    }

    @Override
    public void initView() {
        setTouchDissIm(true);
        setCanScreenshot(false);
        LoginActivityBinding loginActivityBinding = (LoginActivityBinding) getmBinding();
        loginActivityBinding.setPresenter(this);
        loginActivityBinding.setVm(loginViewModel);
    }

    @Override
    public Integer getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void onClick(View var1) {
        switch (var1.getId()) {
            case R.id.login_btn:
                loginViewModel.login().compose(this.<User>bindToLifecycle()).subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        Logger.e("--user-->>" + user.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.e(throwable.getMessage());
                    }
                });

                break;
            default:
        }

    }
}
