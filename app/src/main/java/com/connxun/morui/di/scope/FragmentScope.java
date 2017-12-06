package com.connxun.morui.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author wushange
 * @date 2017/12/4
 */

@Scope
@Retention(RUNTIME)
public  @interface FragmentScope {
}
