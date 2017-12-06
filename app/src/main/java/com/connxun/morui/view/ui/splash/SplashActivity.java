package com.connxun.morui.view.ui.splash;

import android.view.View;

import com.connxun.morui.R;
import com.connxun.morui.view.ui.auth.LoginActivity;
import com.connxun.morui.view.ui.base.BaseActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @author wushange
 * @date 2017/12/4
 */

public class SplashActivity extends BaseActivity {


    @Override
    public void loadData() {

    }

    @Override
    public void initView() {
        Observable.timer(2, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                forward(LoginActivity.class);
            }
        });

    }

    @Override
    public Integer getLayoutId() {
        return R.layout.splash_activity;
    }

    @Override
    public void initInjector() {
        getComponent().inject(this);
    }

    @Override
    public void onClick(View var1) {

    }
}
