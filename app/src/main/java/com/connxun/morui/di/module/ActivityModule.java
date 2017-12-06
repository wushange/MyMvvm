package com.connxun.morui.di.module;

import com.connxun.morui.di.component.FragmentComponent;
import com.connxun.morui.di.scope.ActivityScope;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import dagger.Module;
import dagger.Provides;

/**
 * @author wushange
 * @date 2017/12/4
 */

@Module(subcomponents = {FragmentComponent.class})
public class ActivityModule {
    private final RxAppCompatActivity activity;

    public ActivityModule(RxAppCompatActivity activity) {
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    public final RxAppCompatActivity provideActivity() {
        return this.activity;
    }


}
