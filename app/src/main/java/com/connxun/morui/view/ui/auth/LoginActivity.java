package com.connxun.morui.view.ui.auth;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import com.connxun.morui.R;
import com.connxun.morui.databinding.LoginActivityBinding;
import com.connxun.morui.view.helper.util.RxAnimationTool;
import com.connxun.morui.view.ui.base.BaseActivity;
import com.connxun.morui.viewmodel.LoginViewModel;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

/**
 * @author wushange
 * @date 2017/12/6
 */

public class LoginActivity extends BaseActivity {

    @Inject
    LoginViewModel loginViewModel;
    LoginActivityBinding binding;
    //软件盘弹起后所占高度
    private int keyHeight    = 0;
    //屏幕高度
    private int screenHeight = 0;

    @Override
    public void loadData() {
    }

    @Override
    public void initView() {
        setTouchDissIm(true);
        setCanScreenshot(false);
        binding = (LoginActivityBinding) getmBinding();
        binding.setPresenter(this);
        binding.setVm(loginViewModel);
        //获取屏幕高度
        screenHeight = this.getResources().getDisplayMetrics().heightPixels;
        //弹起高度为屏幕高度的1/3
        keyHeight = screenHeight / 3;
        /**
         * 禁止键盘弹起的时候可以滚动
         */
        binding.scrollView.setOnTouchListener((v, event) -> true);
        binding.scrollView.addOnLayoutChangeListener(onLayoutChangeListener);
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
                loginViewModel.login().compose(this.bindToLifecycle())
                        .subscribe(user -> Logger.e("--user-->>" + user.toString()),
                                throwable -> Logger.e(throwable.getMessage()));

                break;
            default:
        }

    }

    View.OnLayoutChangeListener onLayoutChangeListener = new ViewGroup.OnLayoutChangeListener() {
        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
              /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
            if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
                int dist = binding.context.getBottom() - bottom;
                if (dist > 0) {
                    ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(binding.context, "translationY", 0.0f, -dist);
                    mAnimatorTranslateY.setDuration(300);
                    mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                    mAnimatorTranslateY.start();
                    RxAnimationTool.zoomIn(binding.headLogo, 0.6f, dist);
                }
                binding.copyright.setVisibility(View.INVISIBLE);

            } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
                if ((binding.context.getBottom() - oldBottom) > 0) {
                    ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(binding.context, "translationY", binding.context.getTranslationY(), 0);
                    mAnimatorTranslateY.setDuration(300);
                    mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                    mAnimatorTranslateY.start();
                    //键盘收回后，logo恢复原来大小，位置同样回到初始位置
                    RxAnimationTool.zoomOut(binding.headLogo, 0.6f);
                }
                binding.copyright.setVisibility(View.VISIBLE);
            }
        }
    };
}
