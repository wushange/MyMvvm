package com.connxun.morui.di.component;

import com.connxun.morui.di.module.ActivityModule;
import com.connxun.morui.di.scope.ActivityScope;
import com.connxun.morui.view.ui.auth.LoginActivity;
import com.connxun.morui.view.ui.splash.SplashActivity;

import dagger.Subcomponent;

/**
 * @author wushange
 * @date 2017/12/4
 */

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(LoginActivity activity);

    FragmentComponent.Builder supplyFragmentComponentBuilder();
}
