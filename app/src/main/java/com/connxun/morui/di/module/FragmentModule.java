package com.connxun.morui.di.module;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.trello.rxlifecycle2.components.support.RxFragment;

import dagger.Module;
import dagger.Provides;

/**
 * @author wushange
 * @date 2017/12/4
 */

@Module
public class FragmentModule {
    private final RxFragment fragment;

    public FragmentModule(RxFragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    public final RxFragment provideFragment() {
        return this.fragment;
    }

    @Provides
    public final Context provideContext() {
        return this.fragment.getContext();
    }

    @Provides
    public final FragmentManager provideFragmentManager() {
        return this.fragment.getChildFragmentManager();
    }


}
