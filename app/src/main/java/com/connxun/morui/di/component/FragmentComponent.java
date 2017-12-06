package com.connxun.morui.di.component;

import com.connxun.morui.di.module.FragmentModule;
import com.connxun.morui.di.scope.FragmentScope;

import dagger.Subcomponent;

/**
 * @author wushange
 * @date 2017/12/4
 */

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {


    @Subcomponent.Builder
    public interface Builder {
        FragmentComponent.Builder fragmentModule(FragmentModule var1);

        FragmentComponent build();
    }
}
