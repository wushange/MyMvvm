package com.connxun.morui.view.ui.base;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.connxun.morui.di.component.FragmentComponent;
import com.connxun.morui.di.module.FragmentModule;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * @author wushange
 * @date 2017/12/4
 */

public abstract class BaseFragment<VB extends ViewDataBinding> extends RxFragment {

    protected VB mBinding;
    protected Context mContext;
    protected boolean lazyLoad = false;
    protected boolean visible = false;
    /**
     * 标志位，标志已经初始化完成
     */
    protected boolean isPrepared = false;
    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    protected boolean hasLoadOnce = false;
    private FragmentComponent fragmentComponent = null;
    protected FragmentComponent.Builder fragmentComponentBuild;

    public final FragmentComponent getComponent() {
        if (fragmentComponent != null) {
            return fragmentComponent;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            fragmentComponentBuild = ((BaseActivity) activity).getComponent().supplyFragmentComponentBuilder();
            fragmentComponent = fragmentComponentBuild.fragmentModule(new FragmentModule(this)).build();
        }
        return fragmentComponent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initArgs(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
        initView();
        if (lazyLoad) {
            lazyLoad();
        } else {
            loadData(true);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, this.getLayoutId(), (ViewGroup) null, false);
        return mBinding.getRoot();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (this.getUserVisibleHint()) {
            this.visible = true;
            this.onVisible();
        } else {
            this.visible = false;
            this.onInvisible();
        }

    }

    protected final void onInvisible() {
    }

    protected void onVisible() {
        this.lazyLoad();
    }

    public void lazyLoad() {
    }

    public abstract void initArgs(Bundle bundle);

    public abstract void loadData(boolean isRefresh);

    public abstract void initView();

    public abstract Integer getLayoutId();


}
